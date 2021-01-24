package com.osk2090.Draw.util;

public class ClientSizeCheck {
    //있는 사이즈인지 체크하는 메서드
    static boolean sizeCheck(int mySize) {
        InputDrawInfo d = new InputDrawInfo();
        while (true) {
            for (int i = 0; i < d.SHOE_SIZE.length; i++) {
                if (d.SHOE_SIZE[i] == mySize) {
                    return true;
                }
            }
            return false;
        }
    }
}