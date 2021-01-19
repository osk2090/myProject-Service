package com.osk2090.service;

public class Korea {
    static String[] koreaF = {"김치찌개", "삼겹살", "비빔밥", "불고기", "떡볶이"};//한식
    static int[] koreaPrice = {9000, 12000, 8000, 14000, 3000};

    static void koreaF(int choice) {
        System.out.println("---한식---");
        MenuController.PrintMenu(koreaF.length, koreaF, koreaPrice);
        choice = MenuController.Choice();
        MenuController.QandS(choice, koreaF.length, Delivery.qArray, Delivery.basket, Delivery.pay, koreaF, koreaPrice);
    }
}