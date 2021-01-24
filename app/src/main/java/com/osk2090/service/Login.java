package com.osk2090.service;

public class Login {
    String name = "";

    static String arAcc = "osk";
    static String arPw = "2090";

    public static boolean LoginCheck(String myId, String myPw) {
        if (myId.equals(arAcc) && myPw.equals(arPw)) {
            return true;
        }
        return false;
    }
}