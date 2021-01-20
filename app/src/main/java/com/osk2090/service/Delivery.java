package com.osk2090.service;

import com.osk2090.service.Nation.*;
import com.osk2090.util.Basket;
import com.osk2090.util.MenuController;

public class Delivery {

    static final int SIZE = 100;

    public static String[] basket = new String[SIZE];//장바구니
    public static int[] pay = new int[SIZE];//가격저장
    public static int[] qArray = new int[SIZE];//수량저장

    public static void main(String[] args) {

        System.out.println("---배달의 민족---");
        String printMenu = "1. 한식 2. 일식 3. 중식 4. 양식 5. 디저트";

        boolean run = true;

        while (run) {
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
            } else {
                System.out.println("없는 메뉴입니다.");
            }
        }
        MenuController.close();
    }
}