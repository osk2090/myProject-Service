package com.osk2090.edit_ver.draw.Handler;

import com.osk2090.edit_ver.draw.domain.Client;

import java.util.List;
import java.util.Random;

public abstract class AbstractAdminHandler extends AbstractClientHandler implements Command {

  static String AdminID = "admin";//어드민 기본 아이디
  static int AdminPW = 1234;//어드민 기본 비번
  protected static int r = -1;

  public AbstractAdminHandler(List<Client> clientList) {
    super(clientList);
  }

  public static void setR(int r) {
    AbstractAdminHandler.r = r;
  }

  public int getR() {
    return r;
  }

  static int AdminCheck = -1;//로그인 성공여부
  static String winnerTitle = "현재 당첨자: ";
  static Random ran = new Random();
}