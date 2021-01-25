package com.osk2090.Draw;

import com.osk2090.Draw.util.AdminCheck;
import com.osk2090.Draw.util.InputDrawInfo;
import com.osk2090.Draw.util.Prompt;

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

    public static void AdminLogic() {
        if (AdminCheck.checkResult()) {
            boolean run = true;
            int choice = Prompt.promptInt("1. 추첨하기 2. 응모자리스트 3. 로그아웃");
            while (run) {
                if (choice == 1) {
                    System.out.println("추첨하겠습니다.");
                    Admin.WinnerResult();
                } else if (choice == 2) {
                    Admin.AdminPrintList();
                } else if (choice == 3) {
                    System.out.println("로그아웃 되었습니다.");
                    break;
                } else {
                    System.out.println("없는 메뉴 입니다.");
                }
            }
        }
    }
}