package com.osk2090.service;

import com.osk2090.service.Nation.*;
import com.osk2090.service.util.Basket;
import com.osk2090.service.util.MenuController;
import com.osk2090.service.util.Prompt;

public class Delivery {
    public static void main(String[] args) {

        System.out.println("---배달의 민족---");
        String printMenu = "1. 한식 2. 일식 3. 중식 4. 양식 5. 디저트 9.로그아웃";

        boolean run = true;
        String myId;
        String myPw;
        int checkPoint = -1;

        while (run) {
            System.out.println("---로그인---");
            myId = Prompt.promptString("id입력:");
            myPw = Prompt.promptString("pw입력:");
            boolean checkResult = Login.LoginCheck(myId, myPw);
            if (checkResult) {
                checkPoint = 0;//로그인 됨
                while (checkPoint == 0) {
                    System.out.println(printMenu);
                    System.out.println("0.영수증 출력");
                    System.out.print("메뉴선택> ");
                    int choice = MenuController.scan.nextInt();

                    if (choice == 1) {//한식
                        Korea.koreaF(choice);
                    } else if (choice == 2) {//일식
                        Japan.japanF(choice);
                    } else if (choice == 3) {//중식
                        China.chinaF(choice);
                    } else if (choice == 4) {//양식
                        West.westF(choice);
                    } else if (choice == 5) {//디저트
                        Dessert.dessertF(choice);
                    } else if (choice == 0) {
                        Basket.basket();
                    } else if (choice == 9) {
                        System.out.println("로그아웃 합니다.");
                        checkPoint = -1;
                    } else {
                        System.out.println("없는 메뉴입니다.");
                    }
                }
            } else {
                System.out.println("아이디와 패스워드를 확인해주세요!");
            }
        }
        MenuController.close();
    }
}