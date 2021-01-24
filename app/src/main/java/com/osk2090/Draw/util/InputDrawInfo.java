package com.osk2090.Draw.util;

import com.osk2090.Draw.CLIENT_ROOM.ClientInfo;

public class InputDrawInfo {

    public static final int LENGHT = 1000;//응모자 가능 수
    public static int idx = 0;//회원정보 저장 위치
    static int mySize;

    static int[] SHOE_SIZE = {250, 255, 260, 265, 270, 275, 280, 285, 290, 300};//신발사이즈

    static ClientInfo[] clients = new ClientInfo[LENGHT];

    public void inputInfo() {//응모자 정보 저장
        ClientInfo c = new ClientInfo();

        c.name = Prompt.promptString("정보입력\n응모자 이름: ");
        c.pN = Prompt.promptInt("응모자 전화번호\n예)01012345678-11자리:");
        c.bN = Prompt.promptInt("응모자 생년월일\n예)900101:");
        c.id = Prompt.promptString("나이키 닷컴 아이디를 기재해주세요.\n*나이키 멤버만 구매 가능합니다.\n");

        System.out.println("NIKE DUNK LOW RETRO (DD1391-100)");
        System.out.println("금액: 119.000");
        for (int i = 0; i < SHOE_SIZE.length; i++) {
            System.out.println(SHOE_SIZE[i]);
        }

        mySize = Prompt.promptInt("사이즈 선택:");
        if (ClientSizeCheck.sizeCheck(mySize)) {
            System.out.println("사이즈 확인됨");
            c.size = mySize;
            this.clients[this.idx++] = c;
            System.out.println("응모에 참여해주셔서 감사합니다.");
        } else {
            System.out.println("없는 사이즈 입니다.");
            return;
        }
    }

    public static void list() {
        for (int i = 0; i < InputDrawInfo.idx; i++) {
            ClientInfo c = clients[i];

            System.out.printf("이름: %s 전화번호: %d 생년월일: %d 아이다: %s 사이즈: %s\n",
                    c.name, c.pN, c.bN, c.id, c.size);
        }
    }
}