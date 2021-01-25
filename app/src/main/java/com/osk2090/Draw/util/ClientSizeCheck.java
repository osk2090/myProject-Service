package com.osk2090.Draw.util;

import com.osk2090.Draw.CLIENT_ROOM.ClientInfo;

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

    static void finSizeCheck(ClientInfo c, int mySize) {
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