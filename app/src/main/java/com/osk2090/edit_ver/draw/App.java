package com.osk2090.edit_ver.draw;

import com.osk2090.edit_ver.draw.Handler.*;
import com.osk2090.edit_ver.draw.domain.Client;
import com.osk2090.edit_ver.draw.util.Prompt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class App {
    //사용자가 입력한 명령을 저장할 컬렉션 객체 준비
    static ArrayDeque<Integer> commandStack = new ArrayDeque<>();
    static LinkedList<Integer> commandQueue = new LinkedList<>();

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Client> clientList = new ArrayList<>();

        AdminCheckResultHandler adminCheckResultHandler = new AdminCheckResultHandler(clientList);
        AdminLogicHandler adminLogicHandler = new AdminLogicHandler(clientList);
        AdminWinnerCheckHandler adminWinnerCheckHandler = new AdminWinnerCheckHandler(clientList);
        AdminWinnerResultHandler adminWinnerResultHandler = new AdminWinnerResultHandler(clientList);

        ClientAddHandler clientAddHandler = new ClientAddHandler(clientList);
        ClientInfoHandler clientInfoHandler = new ClientInfoHandler(clientList);
        ClientStatusHandler clientStatusHandler = new ClientStatusHandler(clientList);
        ClientListHandler clientListHandler = new ClientListHandler(clientList);
        ClientPrintOneHandler clientPrintOneHandler = new ClientPrintOneHandler(clientList,clientAddHandler);
        ClientPrintTwoHandler clientPrintTwoHandler = new ClientPrintTwoHandler(clientList, adminCheckResultHandler,
                adminLogicHandler, clientInfoHandler, clientListHandler, adminWinnerResultHandler);
        ClientPrintThreeHandler clientPrintThreeHandler = new ClientPrintThreeHandler(clientList, clientInfoHandler
                , adminWinnerCheckHandler);


        boolean run = true;
        while (run) {
            clientStatusHandler.statusPannel(adminWinnerResultHandler, clientInfoHandler);
            int choice = Prompt.promptInt("-Nike-\n-Draw-\n1. 응모자 2. 관리자 3. 당첨자 수령하기 4.History");

            commandStack.push(choice);//사용자가 입력한 명령을 보관
            commandQueue.offer(choice);

            try {
                if (choice == 1) {
                    clientPrintOneHandler.service();
                } else if (choice == 2) {
                    clientPrintTwoHandler.service();
                } else if (choice == 3) {
                    clientPrintThreeHandler.service();
                } else if (choice == 4) {
                    printCommandHistory(commandQueue.iterator());
                } else {
                    System.out.println("다시 선택해주세요.");
                }
            } catch (Exception e) {
                System.out.println("==================================================");
                System.out.printf("명령어 실행중 오류 발생: %s = %s\n", e.getClass().getName(), e.getMessage());
                System.out.println("==================================================");
            }
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
