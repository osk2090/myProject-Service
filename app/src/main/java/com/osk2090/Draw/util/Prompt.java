package com.osk2090.Draw.util;

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
}