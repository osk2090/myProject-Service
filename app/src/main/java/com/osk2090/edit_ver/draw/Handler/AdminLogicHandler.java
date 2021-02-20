package com.osk2090.edit_ver.draw.Handler;

import com.osk2090.edit_ver.draw.domain.Client;
import com.osk2090.edit_ver.draw.util.Prompt;

import java.util.List;

public class AdminLogicHandler extends AbstractAdminHandler {

  public AdminLogicHandler(List<Client> clientList) {
    super(clientList);
  }

  @Override
  public void service() throws CloneNotSupportedException {

  }

  public void adminLogic(ClientInfoHandler clientInfoHandler,
                         ClientListHandler clientListHandler,
                         AdminWinnerResultHandler adminWinnerResultHandler) throws CloneNotSupportedException {
    boolean run = true;
    while (run) {

      int choice = Prompt.promptInt("1. 추첨하기 2. 응모자리스트 3. 로그아웃");
      if (choice == 1) {
        if (clientInfoHandler.showClients() != 0) {
          System.out.println("추첨하겠습니다.");
          adminWinnerResultHandler.winnerResult(clientInfoHandler);
          return;
        } else {
          System.out.println("현재 입력된 응모자가 없습니다.");
        }
      } else if (choice == 2) {
        if (clientInfoHandler.showClients() == 0) {
          System.out.println("현재 응모자가 없습니다.");
        } else {
          clientListHandler.list();
        }
      } else if (choice == 3) {
        System.out.println("로그아웃 되었습니다.");
        AdminCheck = -1;//로그아웃
        break;
      } else {
        System.out.println("없는 메뉴 입니다.");
      }
    }
  }
}