package com.osk2090.draw;

import com.osk2090.draw.util.Prompt;

import java.util.Scanner;

public class Draw {
    static Scanner scan = new Scanner(System.in);
    static int n = -1;//생성자를 위한 변수

    public Draw() {
        this.n = n;
    }

    public static void main(String[] args) {
        InputDrawInfo inputDrawInfo = new InputDrawInfo();
        boolean run = true;
        String winnerTitle = "현재 당첨자: ";

        while (run) {
            if (n == -1) {
                System.out.println(winnerTitle + "없음");
            } else {
                System.out.println(winnerTitle + InputDrawInfo.clients[n].name + " 님.");
            }
            int choice = Prompt.promptInt("-Nike-\n-Draw-\n1. 응모자 2. 관리자 3. 당첨자 수령하기");
            if (choice == 1) {
                if (Agreement.Agree()) {
                    inputDrawInfo.inputInfo();
                } else {
                    System.out.println("다시 동의하시기 바랍니다.");
                }
            } else if (choice == 2) {
                Admin.AdminLogic();
            } else if (choice == 3) {
                if (InputDrawInfo.idx == 0) {
                    System.out.println("입력된 응모자가 없습니다.");
                } else {
                    Admin.WinnerCheck(InputDrawInfo.clients[n].name, InputDrawInfo.clients[n].id,
                            InputDrawInfo.clients[n].size, n);
                }
            } else {
                System.out.println("다시 선택해주세요.");
            }
        }
    }
}
