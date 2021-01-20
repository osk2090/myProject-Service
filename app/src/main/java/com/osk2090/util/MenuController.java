package com.osk2090.util;

import java.util.Scanner;

public class MenuController {
    public static Scanner scan = new Scanner(System.in);

    public static void PrintMenu(int length, String[] menu, int[] price) {//메뉴출력 메서드
        for (int i = 0; i < length; i++) {
            System.out.printf("%d. %s %d원\n", (i + 1), menu[i], price[i]);
        }
        System.out.println();
    }

    public static int Choice() {//선택메서드
        System.out.print("메뉴선택> ");
        return scan.nextInt() - 1;
    }

    public static void QandS(int choice, int lenght, int[] qArray, String[] basket, int[] pay,
                      String[] mF, int[] mP) {//수량확인하고 장바구니저장
        if (choice + 1 > lenght) {
            System.out.println("해당 메뉴는 없습니다.");
        } else {
            System.out.print("수량> ");
            int quantity = scan.nextInt();

            qArray[cnt] = quantity;
            basket[cnt] = mF[choice];
            pay[cnt] = mP[choice];
            cnt++;
        }
    }
    static int cnt = 0;//인덱스위치
    static int quantity = 0;//수량

    public static void close() {
        scan.close();
    }
}