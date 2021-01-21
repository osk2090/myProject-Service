package com.osk2090.service.Nation;

import com.osk2090.service.Client_Info;
import com.osk2090.util.MenuController;

public class Japan {
    static String[] japanF = {"돈가스", "김밥", "초밥", "회", "라멘"};//일식
    static int[] japanPrice = {10000, 3000, 11000, 20000, 8000};

    public static void japanF(int choice) {
        System.out.println("---일식---");
        MenuController.PrintMenu(japanF.length, japanF, japanPrice);
        choice = MenuController.Choice();
        MenuController.QandS(choice, japanF.length, Client_Info.qArray, Client_Info.basket, Client_Info.pay, japanF, japanPrice);
    }
}