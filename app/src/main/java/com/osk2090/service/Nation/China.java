package com.osk2090.service.Nation;

import com.osk2090.service.Client_Info;
import com.osk2090.util.MenuController;

public class China {
    static String[] chinaF = {"짜장면", "짬뽕", "울면", "탕수육", "유산슬"};//중식
    static int[] chinaPrice = {8000, 8000, 9000, 10000, 15000};

    public static void chinaF(int choice) {
        System.out.println("---중식---");
        MenuController.PrintMenu(chinaF.length, chinaF, chinaPrice);
        choice = MenuController.Choice();
        MenuController.QandS(choice, chinaF.length, Client_Info.qArray, Client_Info.basket, Client_Info.pay, chinaF, chinaPrice);
    }
}