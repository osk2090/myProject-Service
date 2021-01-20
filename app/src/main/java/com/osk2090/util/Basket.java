package com.osk2090.util;

import com.osk2090.service.Delivery;
import com.osk2090.util.MenuController;

public class Basket {
    public static void basket() {
        if (MenuController.cnt == 0) {
            System.out.println("현재 장바구니가 비어있습니다.");
        } else {
            System.out.println("---영수증---");
            int total = 0;
            for (int i = 0; i < MenuController.cnt; i++) {
                System.out.printf("%d. %s %d원---%d개\n", (i + 1), Delivery.basket[i], Delivery.pay[i], Delivery.qArray[i]);
                total += Delivery.pay[i] * Delivery.qArray[i];
            }
            System.out.println();
            System.out.println("----------------------------");
            System.out.printf("              합계:%d원\n", total);
        }
        System.out.println();
    }
}