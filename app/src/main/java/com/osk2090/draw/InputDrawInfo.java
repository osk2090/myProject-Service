package com.osk2090.draw;

import com.osk2090.draw.util.ClientSizeCheck;
import com.osk2090.draw.util.Prompt;

public class InputDrawInfo {
    public static class ClientInfo {
        public String name;//응모자 이름
        public String pN;//응모자 전화번호
        public String bN;//응모자 생년월일
        public String id;//응모자 나이키 아이디
        public int size;//응모자 사이즈
    }
    public static final int LENGHT = 1000;//응모자 가능 수
    public static int idx = 0;//회원정보 저장 위치

    public static int[] SHOE_SIZE = {250, 255, 260, 265, 270, 275, 280, 285, 290, 300};//신발사이즈
    public static ClientInfo[] clients = new ClientInfo[LENGHT];
    static int mySize;

    public static void inputInfo() {//응모자 정보 저장
        ClientInfo c = new ClientInfo();

        c.name = Prompt.promptString("정보입력\n응모자 이름: ");

        Prompt.booleanResult_PN(c, "응모자 전화번호\n예)01012345678-11자리:");
        Prompt.booleanResult_BN(c, "응모자 생년월일\n예)900101-6자리:");

        c.id = Prompt.promptString("나이키 닷컴 아이디를 기재해주세요.\n*나이키 멤버만 구매 가능합니다.");

        System.out.println("NIKE DUNK LOW RETRO (DD1390-100)");
        System.out.println("금액: 129.000 krw");
        for (int i = 0; i < SHOE_SIZE.length; i++) {
            System.out.println(SHOE_SIZE[i]);
        }
        ClientSizeCheck.finSizeCheck(c, mySize);
    }

    public static void list(int length) {
        for (int i = 0; i < length; i++) {
            ClientInfo c = clients[i];
            System.out.printf("이름: %s 전화번호: %s 생년월일: %s 아이디: %s 사이즈: %s\n",
                    c.name, c.pN, c.bN, c.id, c.size);
        }
    }
}