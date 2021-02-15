package com.osk2090.edit_ver.draw;

import com.osk2090.edit_ver.draw.domain.Client;
import com.osk2090.edit_ver.draw.util.List;
import com.osk2090.edit_ver.draw.util.Prompt;

import java.util.Random;

public class Admin {
  private static List clientList = new List();
  private static String AdminID = "admin";//어드민 기본 아이디
  private static int AdminPW = 1234;//어드민 기본 비번
  private static int r = -1;

  public static void setR(int r) {
    Admin.r = r;
  }

  public static int getR() {
    return r;
  }

  public String getAdminID() {
    return AdminID;
  }

  public void setAdminID(String adminID) {
    AdminID = adminID;
  }

  public int getAdminPW() {
    return AdminPW;
  }

  public void setAdminPW(int adminPW) {
    AdminPW = adminPW;
  }

  static int AdminCheck = -1;//로그인 성공여부
  static String winnerTitle = "현재 당첨자: ";
  static Random ran = new Random();

  static int winnerResult() {
    List clientList = new List();
    setR(ran.nextInt(List.size()));

    for (int i = 3; i >= 1; i--) {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.printf("%d! ", i);
    }
    //java.lang.NullPointerException 에러!!!
    Client c = (Client) clientList.get(getR());
    System.out.println("당첨자:" + c.getName());
    System.out.println("축하합니다!");
    return r;
  }

  static void adminLogic() throws CloneNotSupportedException {
    boolean run = true;
    while (run) {

      int choice = Prompt.promptInt("1. 추첨하기 2. 응모자리스트 3. 로그아웃");
      if (choice == 1) {
        if (List.size() != 0) {
          System.out.println("추첨하겠습니다.");
          winnerResult();
          return;
        } else {
          System.out.println("현재 입력된 응모자가 없습니다.");
          choice = Prompt.promptInt("1. 추첨하기 2. 응모자리스트 3. 로그아웃");
        }
      } else if (choice == 2) {
        if (List.size() == 0) {
          System.out.println("현재 응모자가 없습니다.");
          break;
        } else {
          ClientHandler.list();
          break;
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

  static int checkResult() {
    String myAdminId = Prompt.promptString("관리자id: ");
    int myAdminPw = Prompt.promptInt("관리자pw: ");

    if (myAdminId.equals(AdminID) && myAdminPw == AdminPW) {
      System.out.println("관리자님 환영합니다.");
      return 0;
    }
    return -1;
  }

  static void winnerCheck(Object name, Object id, Object size, int n) {
    List clientList = new List();

    System.out.println("--강남 나이키 매장에 오신걸 환영합니다.");
    String winnerName = Prompt.promptString("당첨자 성함:");
    String winnerId = Prompt.promptString("당첨자 나이키 id:");
    int winnerSize = Prompt.promptInt("선택한 사이즈:");

    if (winnerName.equals(name) && winnerId.equals(id) && (Object) winnerSize == size) {
      System.out.println("정보가 확인되었습니다. 수령해가시기 바랍니다.");
      clientList.delete(n);
      return;
    } else {
      System.out.println("정보가 틀립니다.수령하실수 없습니다.");
      System.out.println("응모자 정보를 삭제겠습니다.");
      clientList.delete(n);
      return;
    }
  }

  void winnerStatus() {
    if (getR() == -1) {
      System.out.println(winnerTitle + "없음");
    } else {
      System.out.println(winnerTitle + clientList.get(winnerResult()) + " 님.");
    }
  }
}