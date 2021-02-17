package com.osk2090.edit_ver.draw;

import com.osk2090.edit_ver.draw.util.*;

import java.util.Scanner;

public class App {
    //사용자가 입력한 명령을 저장할 컬렉션 객체 준비
    static Stack<Integer> commandStack = new Stack<>();
    static Queue<Integer> commandQueue = new Queue<>();

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws CloneNotSupportedException {

        ClientHandler clientHandler = new ClientHandler();
        List clientList = new List();
        Admin admin = new Admin();

        boolean run = true;
        while (run) {
            admin.winnerStatus();
            System.out.println("현재 가입명 수:" + List.size());
            int choice = Prompt.promptInt("-Nike-\n-Draw-\n1. 응모자 2. 관리자 3. 당첨자 수령하기 4.History");

            commandStack.push(choice);//사용자가 입력한 명령을 보관
            commandQueue.offer(choice);

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
                if (List.size() == 0) {
                    System.out.println("입력된 응모자가 없습니다.");
                } else {
                    Admin.winnerCheck(clientList.get(admin.getR()),
                            clientList.get(admin.getR()),
                            clientList.get(admin.getR()), admin.getR());
                }
            } else if (choice == 4) {
                printCommandHistory(commandQueue.iterator());
            } else {
                System.out.println("다시 선택해주세요.");
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
