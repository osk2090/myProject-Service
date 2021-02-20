package com.osk2090.edit_ver.draw.Handler;

import com.osk2090.edit_ver.draw.domain.Client;

import java.util.List;

public abstract class AbstractClientHandler implements Command {
    protected static List<Client> clientList;

    public AbstractClientHandler(List<Client> clientList) {
        this.clientList = clientList;
    }

    //신발 출력할때 줄을 나열해서 출력하기
    static int[] SHOE_SIZE = {250, 255, 260, 265, 270, 275, 280, 285, 290, 300};//신발사이즈
    static int mySize = 0;
}