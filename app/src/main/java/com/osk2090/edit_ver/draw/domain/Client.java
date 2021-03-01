package com.osk2090.edit_ver.draw.domain;

import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;//응모자 이름
    private String pN;//응모자 전화번호
    private String bN;//응모자 생년월일
    private String id;//응모자 나이키 아이디
    private int cSize;//응모자 사이즈
    private int idx;//인덱스 번호

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpN() {
        return pN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(pN, client.pN) && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pN, id);//이름 전화번호 아이디
    }

    public void setpN(String pN) {
        this.pN = pN;
    }

    public String getbN() {
        return bN;
    }

    public void setbN(String bN) {
        this.bN = bN;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getcSize() {
        return cSize;
    }

    public void setcSize(int cSize) {
        this.cSize = cSize;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

}