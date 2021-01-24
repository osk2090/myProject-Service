package com.osk2090.service.util;

import java.util.Scanner;

public class Prompt {
    static Scanner scan = new Scanner(System.in);

    public static String promptString(String title) {
        System.out.println(title);
        return scan.nextLine();
    }

    public static int promptInt(String title) {
        return Integer.parseInt(promptString(title));
    }
}