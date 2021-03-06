package com.osk2090.service.Nation;

import com.osk2090.service.Client_Info;
import com.osk2090.service.util.MenuController;
import com.osk2090.service.util.Prompt;

public class Dessert {
    static String[] dessert = {"아메리카노", "라떼", "레모네이드", "홍차", "케잌"};//디저트
    static int[] dessertPrice = {2500, 3500, 2000, 4000, 6000};

    public static void dessertF(int choice) {
        System.out.println("---디저트---");
        MenuController.PrintMenu(dessert.length, dessert, dessertPrice);
        choice = Prompt.promptInt("메뉴선택") - 1;
        MenuController.QandS(choice, dessert.length, Client_Info.qArray, Client_Info.basket, Client_Info.pay, dessert, dessertPrice);
    }
}