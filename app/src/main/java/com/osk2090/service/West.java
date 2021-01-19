package com.osk2090.service;

public class West {
    static String[] westF = {"피자", "치킨", "파스타", "스테이크", "햄버거"};//양식
    static int[] westPrice = {10000, 15000, 12000, 17000, 8000};

    static void westF(int choice) {
        System.out.println("---양식---");
        MenuController.PrintMenu(westF.length, westF, westPrice);
        choice = MenuController.Choice();
        MenuController.QandS(choice, westF.length, Delivery.qArray, Delivery.basket, Delivery.pay, westF, westPrice);
    }
}