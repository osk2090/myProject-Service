package com.osk2090.edit_ver.draw;

import com.osk2090.edit_ver.draw.Handler.*;
import com.osk2090.edit_ver.draw.domain.Client;
import com.osk2090.edit_ver.draw.util.Prompt;

import java.io.*;
import java.util.*;

public class App {
    //사용자가 입력한 명령을 저장할 컬렉션 객체 준비
    static ArrayDeque<Integer> commandStack = new ArrayDeque<>();
    static LinkedList<Integer> commandQueue = new LinkedList<>();

    //VO를 저장할 컬렉션 객체
    static List<Client> clientList;

    //데티어 파일 정보
    static File clientFile = new File("clients.data");

    public static void main(String[] args) throws CloneNotSupportedException {

        //파일에서 데이터를 읽어온다(데이터로딩)
        clientList = loadObjects(clientFile, Client.class);

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
        saveObjects(clientFile, clientList);

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

    static <T extends Serializable> void saveObjects(File file, List<?> dataList) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            out.writeObject(clientList);
            System.out.printf("파일 %s 저장!\n", file.getName());

        } catch (Exception e) {
            System.out.println("회원 데이터를 파일로 저장하는 중에 오류가 발생!");
        }
    }

    @SuppressWarnings("unchecked")
    static <T extends Serializable> List<T> loadObjects(File file, Class<T> dataType) {
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)))) {
            System.out.printf("파일 %s 로딩!\n", file.getName());
            return (List<T>) in.readObject();

        } catch (Exception e) {
            System.out.printf("파일 %s 로딩 중 오류 발생!\n", file.getName());
            return new ArrayList<>();
        }
    }
}
