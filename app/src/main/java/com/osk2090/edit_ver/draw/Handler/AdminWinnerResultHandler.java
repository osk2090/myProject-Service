package com.osk2090.edit_ver.draw.Handler;

import com.osk2090.edit_ver.draw.domain.Client;

import java.util.List;

public class AdminWinnerResultHandler extends AbstractAdminHandler {

  public AdminWinnerResultHandler(List<Client> clientList) {
    super(clientList);
  }

  void winnerResult(ClientInfoHandler clientInfoHandler) {
    for (int i = 3; i >= 1; i--) {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.printf("%d! ", i);
    }
    Client client = clientInfoHandler.getInfo(ran.nextInt(clientInfoHandler.showClients()));
    if (client == null) {
      return;
    }
    System.out.println("당첨자:" + client.getName());
    System.out.println("축하합니다!");
    r = client.getIdx();//당첨자 인덱스 저장
  }

  void winnerStatus(ClientInfoHandler clientInfoHandler) {
    if (getR() == -1) {
      System.out.println(winnerTitle + "없음");
    } else {
      System.out.println(winnerTitle + clientInfoHandler.getInfo(getR()).getName() + " 님.");
    }
  }

  @Override
  public void service() throws CloneNotSupportedException {

  }
}