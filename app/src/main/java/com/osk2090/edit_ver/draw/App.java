package com.osk2090.edit_ver.draw;

import com.osk2090.context.ApplicationContextListener;
import com.osk2090.edit_ver.draw.Handler.*;
import com.osk2090.edit_ver.draw.domain.Client;
import com.osk2090.edit_ver.draw.listener.AppListener;
import com.osk2090.edit_ver.draw.listener.FileListener;
import com.osk2090.edit_ver.draw.util.Prompt;

import java.io.File;
import java.util.*;

public class App {

    //옵저버 객체 목록을 저장할 컬렉션 준비
    List<ApplicationContextListener> listeners = new ArrayList<>();

    //사용자가 입력한 명령을 저장할 컬렉션 객체 준비
    ArrayDeque<Integer> commandStack = new ArrayDeque<>();
    LinkedList<Integer> commandQueue = new LinkedList<>();

    Map<String, Object> appContest = new HashMap<>();

    public static void main(String[] args) {
        App app = new App();
        app.addApplicationContextListener(new AppListener());
        app.addApplicationContextListener(new FileListener());
        app.service();
    }

    public void addApplicationContextListener(ApplicationContextListener listener) {
        listeners.add(listener);
    }

    public void removeApplicationContextListener(ApplicationContextListener listener) {
        listeners.remove(listener);
    }

    @SuppressWarnings("unchecked")
    public void service() {

        notifyOnServiceStarted();

        //파일에서 데이터를 읽어온다(데이터로딩)
        List<Client> clientList = (List<Client>) appContest.get("clientList");

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

        Prompt.close();

        notifyOnServiceStopped();
    }

    private void notifyOnServiceStarted() {
        for (ApplicationContextListener listener : listeners) {
            listener.contextInitialized(appContest);
        }
    }

    private void notifyOnServiceStopped() {
        for (ApplicationContextListener listener : listeners) {
            listener.contextDestroyed(appContest);
        }
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
}
