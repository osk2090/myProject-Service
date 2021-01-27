package com.osk2090.draw.util;

import com.osk2090.draw.InputDrawInfo;

public class ClientSizeCheck {
    //있는 사이즈인지 체크하는 메서드
    static boolean sizeCheck(int mySize) {
        while (true) {
            for (int i = 0; i < InputDrawInfo.SHOE_SIZE.length; i++) {
                if (InputDrawInfo.SHOE_SIZE[i] == mySize) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void finSizeCheck(InputDrawInfo.ClientInfo c, int mySize) {
        boolean run = true;
        while (run) {
            mySize = Prompt.promptInt("사이즈 선택:");
            if (ClientSizeCheck.sizeCheck(mySize)) {
                System.out.println("사이즈 확인됨");
                c.size = mySize;
                InputDrawInfo.clients[InputDrawInfo.idx++] = c;
                System.out.println("응모에 참여해주셔서 감사합니다.");
                run = false;
            } else {
                System.out.println("없는 사이즈 입니다.");
            }
        }
    }
}