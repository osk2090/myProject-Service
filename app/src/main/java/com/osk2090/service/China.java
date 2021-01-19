package com.osk2090.service;

public class China {
    static String[] chinaF = {"짜장면", "짬뽕", "울면", "탕수육", "유산슬"};//중식
    static int[] chinaPrice = {8000, 8000, 9000, 10000, 15000};

    static void chinaF(int choice) {
        System.out.println("---중식---");
        MenuController.PrintMenu(chinaF.length, chinaF, chinaPrice);
        choice = MenuController.Choice();
        MenuController.QandS(choice, chinaF.length, Delivery.qArray, Delivery.basket, Delivery.pay, chinaF, chinaPrice);
    }
}