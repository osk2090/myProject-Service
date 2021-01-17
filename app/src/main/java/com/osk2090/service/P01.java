package com.osk2090.service;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int SIZE = 100;

        System.out.println("---배달의 민족---");

        String[] basket = new String[SIZE];//장바구니
        int[] pay = new int[SIZE];//가격저장
        int[] qArray = new int[SIZE];//수량저장

        String printMenu = "1. 한식 2. 일식 3. 중식 4. 양식 5. 디저트";

        String[] koreaF = {"김치찌개", "삼겹살", "비빔밥", "불고기", "떡볶이"};//한식
        int[] koreaPrice = {9000, 12000, 8000, 14000, 3000};

        String[] japanF = {"돈가스", "김밥", "초밥", "회", "라멘"};//일식
        int[] japanPrice = {10000, 3000, 11000, 20000, 8000};

        String[] chinaF = {"짜장면", "짬뽕", "울면", "탕수육", "유산슬"};//중식
        int[] chinaPrice = {8000, 8000, 9000, 10000, 15000};

        String[] westF = {"피자", "치킨", "파스타", "스테이크", "햄버거"};//양식
        int[] westPrice = {10000, 15000, 12000, 17000, 8000};

        String[] dessert = {"아메리카노", "라떼", "레모네이드", "홍차", "케잌"};//디저트
        int[] dessertPrice = {2500, 3500, 2000, 4000, 6000};

        int cnt = 0;//인덱스위치
        boolean run = true;
        int quantity = 0;//수량

        while (run) {
           System.out.println(printMenu);
            System.out.println("0.영수증 출력");
            System.out.print("메뉴선택> ");
            int choice = scan.nextInt();

            if (choice == 1) {//한식
                System.out.println("---한식---");
                for (int i = 0; i < koreaF.length; i++) {
                    System.out.printf("%d. %s %d원\n", (i + 1), (koreaF[i]), koreaPrice[i]);
                }
                System.out.println();
                System.out.print("메뉴선택> ");
                choice = scan.nextInt() - 1;
                if (choice + 1 > koreaF.length) {
                    System.out.println("해당 메뉴는 없습니다.");
                } else {
                    System.out.print("수량> ");
                    quantity = scan.nextInt();

                    qArray[cnt] = quantity;
                    basket[cnt] = koreaF[choice];
                    pay[cnt] = koreaPrice[choice];
                    cnt++;
                }
            } else if (choice == 2) {//일식
                System.out.println("---일식---");
                for (int i = 0; i < japanF.length; i++) {
                    System.out.printf("%d. %s %d원\n", (i + 1), (japanF[i]), japanPrice[i]);
                }
                System.out.println();
                System.out.print("메뉴선택> ");
                choice = scan.nextInt() - 1;
                if (choice + 1 > japanF.length) {
                    System.out.println("해당 메뉴는 없습니다.");
                } else {
                    System.out.print("수량> ");
                    quantity = scan.nextInt();

                    qArray[cnt] = quantity;
                    basket[cnt] = japanF[choice];
                    pay[cnt] = japanPrice[choice];
                    cnt++;
                }
            } else if (choice == 3) {//중식
                System.out.println("---중식---");
                for (int i = 0; i < chinaF.length; i++) {
                    System.out.printf("%d. %s %d원\n", (i + 1), (chinaF[i]), chinaPrice[i]);
                }
                System.out.println();
                System.out.print("메뉴선택> ");
                choice = scan.nextInt() - 1;
                if (choice + 1 > chinaF.length) {
                    System.out.println("해당 메뉴는 없습니다.");
                } else {
                    System.out.print("수량> ");
                    quantity = scan.nextInt();

                    qArray[cnt] = quantity;
                    basket[cnt] = chinaF[choice];
                    pay[cnt] = chinaPrice[choice];
                    cnt++;
                }
            } else if (choice == 4) {//양식
                System.out.println("---양식---");
                for (int i = 0; i < westF.length; i++) {
                    System.out.printf("%d. %s %d원\n", (i + 1), (westF[i]), westPrice[i]);
                }
                System.out.println();
                System.out.print("메뉴선택> ");
                choice = scan.nextInt() - 1;
                if (choice + 1 > westF.length) {
                    System.out.println("해당 메뉴는 없습니다.");
                } else {
                    System.out.print("수량> ");
                    quantity = scan.nextInt();

                    qArray[cnt] = quantity;
                    basket[cnt] = westF[choice];
                    pay[cnt] = westPrice[choice];
                    cnt++;
                }
            } else if (choice == 5) {//디저트
                System.out.println("---디저트---");
                for (int i = 0; i < dessert.length; i++) {
                    System.out.printf("%d. %s %d원\n", (i + 1), (dessert[i]), dessertPrice[i]);
                }
                System.out.println();
                System.out.print("메뉴선택> ");
                choice = scan.nextInt() - 1;
                if (choice + 1 > dessert.length) {
                    System.out.println("해당 메뉴는 없습니다.");
                } else {
                    System.out.print("수량> ");
                    quantity = scan.nextInt();

                    qArray[cnt] = quantity;
                    basket[cnt] = dessert[choice];
                    pay[cnt] = dessertPrice[choice];
                    cnt++;
                }
            } else if (choice == 0) {
                if (cnt == 0) {
                    System.out.println("현재 장바구니가 비어있습니다.");
                } else {
                    System.out.println("---영수증---");
                    int total = 0;
                    for (int i = 0; i < cnt; i++) {
                        System.out.printf("%d. %s %d원---%d개\n", (i + 1), basket[i], pay[i], qArray[i]);
                        total += pay[i] * qArray[i];
                    }
                    System.out.println();
                    System.out.println("----------------------------");
                    System.out.printf("              합계:%d원\n", total);
                }
            } else {
                System.out.println("없는 메뉴입니다.");
            }
        }
    }
}