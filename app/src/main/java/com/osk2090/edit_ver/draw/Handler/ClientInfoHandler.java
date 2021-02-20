package com.osk2090.edit_ver.draw.Handler;

import com.osk2090.edit_ver.draw.domain.Client;

import java.util.List;

public class ClientInfoHandler extends AbstractClientHandler {

    public ClientInfoHandler(List<Client> clientList) {
        super(clientList);
    }

    public static int showClients() {//카운팅
        return clientList.size();
    }

    public static Client getInfo(int clientNo) {//정보가져오기
        return clientList.get(clientNo);
    }

    public void removeClinet(int clientNo,List<Client> clientList) {
//        int temp = clientList.get(clientNo).getIdx();

        clientList.remove(clientNo);
//        for (int i = temp; i < clientList.size() - 1; i++) {
//            clientList.get(i + 1).setIdx(i);
//        }
    }

    @Override
    public void service() throws CloneNotSupportedException {

    }
}