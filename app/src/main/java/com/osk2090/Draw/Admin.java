package com.osk2090.Draw;

import com.osk2090.Draw.util.InputDrawInfo;

public class Admin {

    public static String myAdminId;
    public static int myAdminPw;

    public static void AdminPrintList() {//관리
        if (InputDrawInfo.idx == 0) {
            System.out.println("현재 응모자가 없습니다.");
        } else {
            InputDrawInfo.list();
        }
    }
}