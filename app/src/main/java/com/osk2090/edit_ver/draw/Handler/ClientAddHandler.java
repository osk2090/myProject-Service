package com.osk2090.edit_ver.draw.Handler;

import com.osk2090.edit_ver.draw.domain.Client;
import com.osk2090.edit_ver.draw.util.Prompt;

import java.util.List;

public class ClientAddHandler extends AbstractClientHandler {
//    private static ArrayList<Client> clientList = new ArrayList<>();

    //신발 출력할때 줄을 나열해서 출력하기
    int[] SHOE_SIZE = {250, 255, 260, 265, 270, 275, 280, 285, 290, 300};//신발사이즈
    int mySize = 0;
    static int cnt = 0;

    public ClientAddHandler(List<Client> clientList) {
        super(clientList);
    }

    public void add() {
        Client c = new Client();
        c.setIdx(cnt++);//인덱스 자동으로 넣기
        c.setName(Prompt.promptString("정보입력\n응모자 이름: "));
        Prompt.booleanResult_PN(c, "응모자 전화번호\n예)01012345678-11자리:");
        Prompt.booleanResult_BN(c, "응모자 생년월일\n예)900101-6자리:");
        c.setId(Prompt.promptString("나이키 닷컴 아이디를 기재해주세요.\n*나이키 멤버만 구매 가능합니다."));
        System.out.println("NIKE DUNK LOW RETRO (DD1390-100)");
        System.out.println("금액: 129.000 krw");
        for (int i = 0; i < SHOE_SIZE.length; i++) {
            if (i % 5 == 0) {
                System.out.println();//두줄로 나누기
            }
            System.out.print(SHOE_SIZE[i] + " ");
        }
        System.out.println();
        ClientSizeCheckHandler.finSizeCheck(c, mySize);
    }

    @Override
    public void service() throws CloneNotSupportedException {

    }
}