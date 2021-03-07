package com.osk2090.edit_ver.draw;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.osk2090.edit_ver.draw.Handler.*;
import com.osk2090.edit_ver.draw.domain.Client;
import com.osk2090.edit_ver.draw.util.CsvObject;
import com.osk2090.edit_ver.draw.util.ObjectFactory;
import com.osk2090.edit_ver.draw.util.Prompt;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class App {
    //사용자가 입력한 명령을 저장할 컬렉션 객체 준비
    ArrayDeque<Integer> commandStack = new ArrayDeque<>();
    LinkedList<Integer> commandQueue = new LinkedList<>();

    //VO를 저장할 컬렉션 객체
    ArrayList<Client> clientList = new ArrayList<>();

    //데이터 파일 정보
    File clientFile = new File("clients.json");

    public static void main(String[] args) {
        App app = new App();
        app.service();
    }

    public void service() {

        //파일에서 데이터를 읽어온다(데이터로딩)
        loadClients(clientFile, clientList, Client.class);

        HashMap<Integer, Command> commandMap = new HashMap<>();

        AdminCheckResultHandler adminCheckResultHandler = new AdminCheckResultHandler(clientList);
        AdminLogicHandler adminLogicHandler = new AdminLogicHandler(clientList);
        AdminWinnerCheckHandler adminWinnerCheckHandler = new AdminWinnerCheckHandler(clientList);
        AdminWinnerResultHandler adminWinnerResultHandler = new AdminWinnerResultHandler(clientList);

        ClientAddHandler clientAddHandler = new ClientAddHandler(clientList);
        ClientInfoHandler clientInfoHandler = new ClientInfoHandler(clientList);
        ClientStatusHandler clientStatusHandler = new ClientStatusHandler(clientList);
        ClientListHandler clientListHandler = new ClientListHandler(clientList);
        commandMap.put(1, new ClientPrintOneHandler(clientList, clientAddHandler));
        commandMap.put(2, new ClientPrintTwoHandler(clientList, adminCheckResultHandler,
                adminLogicHandler, clientInfoHandler, clientListHandler, adminWinnerResultHandler));
        commandMap.put(3, new ClientPrintThreeHandler(clientList, clientInfoHandler
                , adminWinnerCheckHandler));

        loop:
        while (true) {
            clientStatusHandler.statusPannel(adminWinnerResultHandler, clientInfoHandler);
            int choice = Prompt.promptInt("-Nike-\n-Draw-\n1. 응모자 2. 관리자 3. 당첨자 수령하기 4. History 0. 종료");

            commandStack.push(choice);//사용자가 입력한 명령을 보관
            commandQueue.offer(choice);

            try {
                switch (choice) {
                    case 4:
                        printCommandHistory(commandQueue.iterator());
                        break;
                    case 0:
                        System.out.println("종료합니다.");
                        break loop;
                    default:
                        Command commandHandler = commandMap.get(choice);

                        if (0 > choice || choice > 4) {
                            System.out.println("다시 선택해주세요.");
                        } else {
                            commandHandler.service();
                        }
                }
            } catch (Exception e) {
                System.out.println("==================================================");
                System.out.printf("명령어 실행중 오류 발생: %s = %s\n", e.getClass().getName(), e.getMessage());
                System.out.println("==================================================");
            }
        }
        //데이터를 파일로 출력한다
        saveClients(clientFile, clientList);

        Prompt.close();
    }

    static void printCommandHistory(Iterator<Integer> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if ((++count % 5) == 0) {
                String input = Prompt.promptString(": ");
                if (input.equalsIgnoreCase("q")) {
                    break;
                }
            }
        }
    }

    static <T> void loadClients(File file, List<T> list, Class<T> elementType) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            StringBuilder strBuilder = new StringBuilder();
            String str = null;
            while ((str = in.readLine()) != null) {
                strBuilder.append(str);
            }
            Type collectionType = TypeToken.getParameterized(Collection.class, elementType).getType();
            Collection<T> collection = new Gson().fromJson(strBuilder.toString(), collectionType);
            list.addAll(collection);
            System.out.printf("%s 파일 데이터 로딩!\n", file.getName());
        } catch (Exception e) {
            System.out.printf("%s 파일 데이터 로딩 중 오류 발생!\n", file.getName());
        }
    }

    static <T extends CsvObject> void saveClients(File file, List<T> list) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            out.write(new Gson().toJson(list));
            System.out.printf("%s 파일 데이터 저장!\n", file.getName());
        } catch (Exception e) {
            System.out.printf("%s 파일 데이터 저장하는 중 오류 발생!\n", file.getName());
        }
    }
}
