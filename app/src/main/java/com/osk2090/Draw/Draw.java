package com.osk2090.Draw;

import com.osk2090.Draw.util.AdminCheck;
import com.osk2090.Draw.util.InputDrawInfo;
import com.osk2090.Draw.util.Prompt;

import java.util.Scanner;

public class Draw {

    static Scanner scan = new Scanner(System.in);

    //1.당첨자가 나왔다 그리고 신발 수령시 이름과 생년월일을 확인해서 다르면 미수령으로 돌린다

    public static void main(String[] args) {
        InputDrawInfo inputDrawInfo = new InputDrawInfo();

        boolean run = true;
        while (run) {
            int choice = Prompt.promptInt("-Nike-\n-Draw-\n1. 응모자 2. 관리자");

            if (choice == 1) {
                if (Agreement.Agree()) {
                    inputDrawInfo.inputInfo();
                } else {
                    System.out.println("다시 동의하시기 바랍니다.");
                }
            } else if (choice == 2) {
                    if (AdminCheck.checkResult()) {
                        run = true;
                        choice = Prompt.promptInt("1. 추첨하기 2. 응모자리스트 3. 로그아웃");
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
            } else {
                System.out.println("다시 선택해주세요.");
            }
        }
    }
}
