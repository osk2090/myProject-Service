package com.osk2090.Draw;

import java.util.Random;
import java.util.Scanner;

public class Draw {
    static class Member {//응모자 정보
        String name;//응모자 이름
        int pN;//응모자 전화번호
        int bN;//응모자 생년월일
    }

    static Random ran = new Random();
    static Scanner scan = new Scanner(System.in);
    static int choice = 0;

    static final int LENGHT = 1000;//응모자 가능 수
    static Member[] members = new Member[LENGHT];//응모자 정보 가입 메모리
    static int idx = 0;//회원정보 저장 위치

    //1.당첨자가 나왔다 그리고 신발 수령시 이름과 생년월일을 확인해서 다르면 미수령으로 돌린다
    //2.전화번호와 생년월일 숫자수를 세서 옳바른 길이의 문자열인지 확인하는 메서드

    static void inputInfo() {//응모자 정보 저장
        Member m = new Member();

        System.out.println("정보입력");
        System.out.println("응모자 이름: ");
        m.name = scan.nextLine();

        System.out.println("응모자 전화번호: ");
        System.out.println("예)01012345678-11자리");
        m.pN = scan.nextInt();

        System.out.println("응모자 생년월일: ");
        System.out.println("예)900101");
        m.bN = scan.nextInt();

        scan.nextLine();
        members[idx++] = m;//저장
    }

    static boolean Agree() {
        String y = "y";
        System.out.println("개인정보 수집 및 이용에 동의합니다.[Y/N]");
        String agree = scan.nextLine();
        if (agree.equalsIgnoreCase(y)) {
            System.out.println("당첨 되실 경우 당첨자 본인만 당첨 매장에 방문하여 수령 가능합니다.[Y/N]");
            agree = scan.nextLine();
            if (agree.equalsIgnoreCase(y)) {
                System.out.println("당첨자는 본인 확인을 위해 신분증 및 핸드폰으로 받으신 SMS(원본)을 확인하오니 지참해주시기 바랍니다.[Y/N]");
                agree = scan.nextLine();
                if (agree.equalsIgnoreCase(y)) {
                    System.out.println("당첨자는 공지 드리는 구매 기간 외에는 구매 불가하며, 카드 결제시 본인 명의 카드로만 결제가 가능합니다.[Y/N]");
                    agree = scan.nextLine();
                    if (agree.equalsIgnoreCase(y)) {
                        System.out.println("다음 진행");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static int AdminPrintList(int choice) {//관리
        if (choice == 2) {
            if (idx == 0) {
                System.out.println("현재 응모자가 없습니다.");
            } else {
                for (int i = 0; i < idx; i++) {
                    Member m = members[i];
                    System.out.printf("이름: %s 전화번호: %d 생년월일: %d\n", m.name, m.pN, m.bN);
                }
            }
        }else {
            System.out.println("해당 메뉴는 없습니다.");
        }
        return choice;
    }

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("-Nike-");
            System.out.println("-Draw-");
            System.out.println("1. 응모자 2. 관리자");
            choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                if (Agree()) {
                    inputInfo();
                } else {
                    System.out.println("다시 동의하시기 바랍니다.");
                }
            } else if (choice == 2) {
                AdminPrintList(choice);
            }
        }
    }
}
