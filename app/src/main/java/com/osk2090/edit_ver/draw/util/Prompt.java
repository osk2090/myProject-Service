package com.osk2090.edit_ver.draw.util;

import com.osk2090.edit_ver.draw.domain.Client;

import java.util.Scanner;

public class Prompt {
    static Scanner scan = new Scanner(System.in);

    public static String promptString(String title) {//문자열입력
        System.out.println(title);
        return scan.nextLine();
    }

    public static int promptInt(String title) {//정수입력
        return Integer.parseInt(promptString(title));
    }

    public static boolean PhoneNumberCheck(String number) {
        if (number.length() == 11) {
            return true;
        }
        return false;
    }

    public static boolean BirthNumberCheck(String number) {
        if (number.length() == 6) {
            return true;
        }
        return false;
    }

    public static void booleanResult_PN(Client c, String title) {
        boolean check = true;
        while (check) {
            c.setpN(Prompt.promptString(title));
            if (Prompt.PhoneNumberCheck(c.getpN())) {
                System.out.println("번호길이 맞습니다.");
                check = false;
            } else {
                System.out.println("번호길이가 맞지않습니다.");
            }
        }
    }

    public static void booleanResult_BN(Client c, String title) {
        boolean check = true;
        while (check) {
            c.setbN(Prompt.promptString(title));
            if (Prompt.BirthNumberCheck(c.getbN())) {
                System.out.println("생년월일 길이 맞습니다.");
                check = false;
            } else {
                System.out.println("생년월일 길이가 맞지않습니다.");
            }
        }
    }
}