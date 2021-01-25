package com.osk2090.Draw;

import com.osk2090.Draw.util.AdminCheck;
import com.osk2090.Draw.util.InputDrawInfo;
import com.osk2090.Draw.util.Prompt;

import java.util.Random;
import java.util.Scanner;

public class Draw {

    static Scanner scan = new Scanner(System.in);
    static Random ran = new Random();

    //1.당첨자가 나왔다 그리고 신발 수령시 이름과 생년월일을 확인해서 다르면 미수령으로 돌린다
    //2.전화번호와 생년월일 숫자수를 세서 옳바른 길이의 문자열인지 확인하는 메서드

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
                    Admin.AdminPrintList();
                }
            } else {
                System.out.println("다시 선택해주세요.");
            }
        }
    }
}
