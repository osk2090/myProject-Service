package com.osk2090.service.Nation;

import com.osk2090.service.Client_Info;
import com.osk2090.service.util.MenuController;
import com.osk2090.service.util.Prompt;

public class West {
    static String[] westF = {"피자", "치킨", "파스타", "스테이크", "햄버거"};//양식
    static int[] westPrice = {10000, 15000, 12000, 17000, 8000};

    public static void westF(int choice) {
        System.out.println("---양식---");
        MenuController.PrintMenu(westF.length, westF, westPrice);
        choice = Prompt.promptInt("메뉴선택") - 1;
        MenuController.QandS(choice, westF.length, Client_Info.qArray, Client_Info.basket, Client_Info.pay, westF, westPrice);
    }
}