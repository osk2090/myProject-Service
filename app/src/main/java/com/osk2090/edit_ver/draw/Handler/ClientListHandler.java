package com.osk2090.edit_ver.draw.Handler;

import com.osk2090.edit_ver.draw.domain.Client;

import java.util.Iterator;
import java.util.List;

public class ClientListHandler extends AbstractClientHandler {

    public ClientListHandler(List<Client> clientList) {
        super(clientList);
    }

    public static void list() throws CloneNotSupportedException {
        System.out.println("응모자 목록");
        Iterator<Client> iterator = clientList.iterator();
        while (iterator.hasNext()) {
            Client c1 = iterator.next();
            System.out.printf("%d. 이름: %s 전화번호: %s 생년월일: %s 아이디: %s 사이즈: %s\n",
                    c1.getIdx(), c1.getName(), c1.getpN(), c1.getbN(), c1.getId(), c1.getcSize());
        }
    }

    @Override
    public void service() throws CloneNotSupportedException {

    }
}