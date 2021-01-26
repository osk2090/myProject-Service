package com.osk2090.Draw;

import com.osk2090.Draw.ADMIN_ROOM.AdminInfo;
import com.osk2090.Draw.util.InputDrawInfo;
import com.osk2090.Draw.util.Prompt;

import java.util.Random;

public class Admin {
    static Random ran = new Random();

    public static String myAdminId;
    public static int myAdminPw;
    int a = WinnerResult();

    public static void AdminPrintList() {//관리
        if (InputDrawInfo.idx == 0) {
            System.out.println("현재 응모자가 없습니다.");
        } else {
            InputDrawInfo.list(InputDrawInfo.idx);
        }
    }

    public static int WinnerResult() {
        int n = ran.nextInt(InputDrawInfo.idx);
        System.out.println("당첨자:" + InputDrawInfo.clients[n].name);
        System.out.println("축하합니다!");
        return n;
    }

    public static void AdminLogic() {
        if (checkResult()) {
            boolean run = true;
            int choice = Prompt.promptInt("1. 추첨하기 2. 응모자리스트 3. 로그아웃");
            while (run) {
                if (choice == 1) {
                    System.out.println("추첨하겠습니다.");
                    WinnerResult();
                    if (InputDrawInfo.idx == 0) {
                        System.out.println("등록된 응모자가 없습니다.");
                    }
                } else if (choice == 2) {
                    AdminPrintList();
                } else if (choice == 3) {
                    System.out.println("로그아웃 되었습니다.");
                    break;
                } else {
                    System.out.println("없는 메뉴 입니다.");
                }
            }
        }
    }

    public static boolean checkResult() {
        Admin.myAdminId = Prompt.promptString("관리자id: ");
        Admin.myAdminPw = Prompt.promptInt("관리자pw: ");

        if (myAdminId.equals(AdminInfo.AdminID) && myAdminPw == AdminInfo.AdminPW) {
            System.out.println("관리자님 환영합니다.");
            return true;
        }
        System.out.println("관리자의 아이디와 비밀번호를 확인해주세요.");
        return false;
    }

    public static void WinnerCheck(int n) {
        System.out.println("--강남 나이키 매장에 오신걸 환영합니다.");
        String winnerName = Prompt.promptString("당첨자 성함:");
        String winnerId = Prompt.promptString("당첨자 나이키 id:");
        int winnerSize = Prompt.promptInt("선택한 사이즈:");

        if (winnerName.equals(InputDrawInfo.clients[n].name) && winnerId.equals(InputDrawInfo.clients[n].id) &&
                winnerSize == InputDrawInfo.clients[n].size) {
            System.out.println("정보가 확인되었습니다. 수령해가시기 바랍니다.");
        } else {
            System.out.println("정보가 틀립니다.수령하실수 없습니다.");
            InputDrawInfo.clients[n] = null;//해당 당첨자 정보 삭제
            System.out.println("응모자 정보를 땡기겠습니다.");
            for (int i = 0; i < InputDrawInfo.idx; i++) {
                InputDrawInfo.clients[i] = InputDrawInfo.clients[i + 1];
            }
        }
    }
}