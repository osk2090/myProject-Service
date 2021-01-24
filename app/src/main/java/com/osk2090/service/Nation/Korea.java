package com.osk2090.service.Nation;

import com.osk2090.service.Client_Info;
import com.osk2090.service.util.MenuController;
import com.osk2090.service.util.Prompt;

public class Korea {
    static String[] koreaF = {"김치찌개", "삼겹살", "비빔밥", "불고기", "떡볶이"};//한식
    static int[] koreaPrice = {9000, 12000, 8000, 14000, 3000};

    public static void koreaF(int choice) {
        System.out.println("---한식---");
        MenuController.PrintMenu(koreaF.length, koreaF, koreaPrice);
        choice = Prompt.promptInt("메뉴선택") - 1;
        MenuController.QandS(choice, koreaF.length, Client_Info.qArray, Client_Info.basket, Client_Info.pay, koreaF, koreaPrice);
    }
}