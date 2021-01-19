package com.osk2090.service;

public class Japan {
    static String[] japanF = {"돈가스", "김밥", "초밥", "회", "라멘"};//일식
    static int[] japanPrice = {10000, 3000, 11000, 20000, 8000};

    static void japanF(int choice) {
        System.out.println("---일식---");
        MenuController.PrintMenu(japanF.length, japanF, japanPrice);
        choice = MenuController.Choice();
        MenuController.QandS(choice, japanF.length, Delivery.qArray, Delivery.basket, Delivery.pay, japanF, japanPrice);
    }
}