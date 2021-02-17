package com.osk2090.edit_ver.draw;

import com.osk2090.edit_ver.draw.domain.Client;
import com.osk2090.edit_ver.draw.util.Prompt;

import java.util.*;

public class App {
    //사용자가 입력한 명령을 저장할 컬렉션 객체 준비
    static ArrayDeque<Integer> commandStack = new ArrayDeque<>();
    static LinkedList<Integer> commandQueue = new LinkedList<>();

    public static void main(String[] args) throws CloneNotSupportedException {
        ClientHandler clientHandler = new ClientHandler();
        Admin admin = new Admin();

        /*
        생년월일과 전화번호를 숫자만 받을수 있게!
         */

        boolean run = true;
        while (run) {
            statusPannel(admin, clientHandler);
            int choice = Prompt.promptInt("-Nike-\n-Draw-\n1. 응모자 2. 관리자 3. 당첨자 수령하기 4.History");

            commandStack.push(choice);//사용자가 입력한 명령을 보관
            commandQueue.offer(choice);

            try {
                if (choice == 1) {
                    if (Agreement.Agree()) {
                        clientHandler.add();
                    }
                } else if (choice == 2) {
                    int check = Admin.checkResult();
                    if (check == 0) {
                        admin.adminLogic();
                    } else {
                        System.out.println("관리자의 아이디와 비밀번호를 확인해주세요.");
                        choice = Prompt.promptInt("-Nike-\n-Draw-\n1. 응모자 2. 관리자 3. 당첨자 수령하기 4.History");
                    }
                } else if (choice == 3) {
                    if (clientHandler.showClients() == 0) {
                        System.out.println("입력된 응모자가 없습니다.");
                    } else {
                        Client c = clientHandler.getInfo(admin.getR());

                        Admin.winnerCheck(c.getName(), c.getId(), c.getcSize(), c.getIdx());
                    }
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

    static void statusPannel(Admin admin, ClientHandler clientHandler) {
        System.out.println("===============================================");
        admin.winnerStatus();
        System.out.printf("현재 가입자: %d 명\n", clientHandler.showClients());
        System.out.println("===============================================");
    }
}
