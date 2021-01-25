package com.osk2090.Draw;

import com.osk2090.Draw.util.InputDrawInfo;

import java.util.Random;

public class Admin {
    static Random ran = new Random();

    public static String myAdminId;
    public static int myAdminPw;

    public static void AdminPrintList() {//관리
        if (InputDrawInfo.idx == 0) {
            System.out.println("현재 응모자가 없습니다.");
        } else {
            InputDrawInfo.list();
        }
    }

    public static void WinnerResult() {
        int n = ran.nextInt(InputDrawInfo.idx);
        System.out.println("당첨자:" + InputDrawInfo.clients[n].name);
        System.out.println("축하합니다!");
    }
}