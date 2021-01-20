package com.osk2090.service.Nation;

import com.osk2090.service.Delivery;
import com.osk2090.util.MenuController;

public class Dessert {
    static String[] dessert = {"아메리카노", "라떼", "레모네이드", "홍차", "케잌"};//디저트
    static int[] dessertPrice = {2500, 3500, 2000, 4000, 6000};

    public static void dessertF(int choice) {
        System.out.println("---디저트---");
        MenuController.PrintMenu(dessert.length, dessert, dessertPrice);
        choice = MenuController.Choice();
        MenuController.QandS(choice, dessert.length, Delivery.qArray, Delivery.basket, Delivery.pay, dessert, dessertPrice);
    }
}