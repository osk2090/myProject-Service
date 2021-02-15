package com.osk2090.edit_ver.draw;

import com.osk2090.edit_ver.draw.domain.Client;
import com.osk2090.edit_ver.draw.util.Iterator;
import com.osk2090.edit_ver.draw.util.List;
import com.osk2090.edit_ver.draw.util.Prompt;

public class ClientHandler {
    private static List clientList = new List();

    int[] SHOE_SIZE = {250, 255, 260, 265, 270, 275, 280, 285, 290, 300};//신발사이즈
    int mySize = 0;

    public void add() {
        Client c = new Client();
        c.setName(Prompt.promptString("정보입력\n응모자 이름: "));
        Prompt.booleanResult_PN(c, "응모자 전화번호\n예)01012345678-11자리:");
        Prompt.booleanResult_BN(c, "응모자 생년월일\n예)900101-6자리:");
        c.setId(Prompt.promptString("나이키 닷컴 아이디를 기재해주세요.\n*나이키 멤버만 구매 가능합니다."));
        System.out.println("NIKE DUNK LOW RETRO (DD1390-100)");
        System.out.println("금액: 129.000 krw");
        for (int i = 0; i < SHOE_SIZE.length; i++) {
            System.out.println(SHOE_SIZE[i]);
        }
        finSizeCheck(c, mySize);
    }

    private void finSizeCheck(Client c, int mySize) {
        boolean run = true;
        while (run) {
            mySize = Prompt.promptInt("사이즈 선택:");
            if (sizeCheck(mySize) != -1) {
                System.out.println("사이즈 확인됨");
                c.setcSize(mySize);
                c.setIdx(List.size());//인덱스 자동으로 넣기
                List.setSize(List.size() + 1);//그리고 +1증가해서 다시 넣기
                clientList.add(c);//최종저장
                System.out.println("응모에 참여해주셔서 감사합니다.");
                run = false;
            } else if (sizeCheck(mySize) == -1) {
                System.out.println("없는 사이즈 입니다.");
            }
        }
    }

    int sizeCheck(int mySize) {
        while (true) {
            for (int i = 0; i < SHOE_SIZE.length; i++) {
                if (SHOE_SIZE[i] == mySize) {
                    return mySize;
                }
            }
            return -1;
        }
    }

    public static void list() throws CloneNotSupportedException {
        System.out.println("응모자 목록");
        Iterator iterator = clientList.iterator();
        while (iterator.hasNext()) {
            Client c1 = (Client) iterator.next();
            System.out.printf("%d. 이름: %s 전화번호: %s 생년월일: %s 아이디: %s 사이즈: %s\n",
                    c1.getIdx(), c1.getName(), c1.getpN(), c1.getbN(), c1.getId(), c1.getcSize());
        }
    }
}