package com.osk2090.Draw;

import com.osk2090.Draw.util.Prompt;

import java.util.Random;

public class Admin {
  public static String AdminID = "admin";//어드민 기본 아이디
  public static int AdminPW = 1234;//어드민 기본 비번
  static Random ran = new Random();
  static int AdminCheck = -1;//로그인 성공여부

  public static String myAdminId;
  public static int myAdminPw;
  static boolean run = true;

  public static int WinnerResult() {
    int n = ran.nextInt(InputDrawInfo.idx);
    for (int i = 3; i >= 1; i--) {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.printf("%d! ", i);
    }
//    if (InputDrawInfo.clients[n].name.equals("수령자") || InputDrawInfo.clients[n].name.equals("미수령자")) {//수령자/미수령자 중복체크하는거 보수하기
//      while (run) {
//        n = ran.nextInt(InputDrawInfo.idx);
//        run = false;
//      }
//    }
    System.out.println("당첨자:" + InputDrawInfo.clients[n].name);
    System.out.println("축하합니다!");
    return Draw.n = n;
  }

  public static void AdminLogic() {
    if (checkResult() == 0) {
      boolean run = true;
      int choice = Prompt.promptInt("1. 추첨하기 2. 응모자리스트 3. 로그아웃");
      while (run) {
        if (choice == 1) {
          if (InputDrawInfo.idx != 0) {
            System.out.println("추첨하겠습니다.");
            WinnerResult();
            return;
          } else {
            System.out.println("현재 입력된 응모자가 없습니다.");
            choice = Prompt.promptInt("1. 추첨하기 2. 응모자리스트 3. 로그아웃");
          }
        } else if (choice == 2) {
          if (InputDrawInfo.idx == 0) {
            System.out.println("현재 응모자가 없습니다.");
            choice = Prompt.promptInt("1. 추첨하기 2. 응모자리스트 3. 로그아웃");
          } else {
            InputDrawInfo.list(InputDrawInfo.idx);
            choice = Prompt.promptInt("1. 추첨하기 2. 응모자리스트 3. 로그아웃");
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

  public static int checkResult() {
    Admin.myAdminId = Prompt.promptString("관리자id: ");
    Admin.myAdminPw = Prompt.promptInt("관리자pw: ");

    if (myAdminId.equals(AdminID) && myAdminPw == AdminPW) {
      System.out.println("관리자님 환영합니다.");
      return AdminCheck = 0;
    }
    System.out.println("관리자의 아이디와 비밀번호를 확인해주세요.");
    return AdminCheck = -1;
  }

  public static void WinnerCheck(String name,String id, int size,int n) {
    System.out.println("--강남 나이키 매장에 오신걸 환영합니다.");
    String winnerName = Prompt.promptString("당첨자 성함:");
    String winnerId = Prompt.promptString("당첨자 나이키 id:");
    int winnerSize = Prompt.promptInt("선택한 사이즈:");

    if (winnerName.equals(name) && winnerId.equals(id) && winnerSize == size) {
      System.out.println("정보가 확인되었습니다. 수령해가시기 바랍니다.");
      InputDrawInfo.clients[n].id = null;
      InputDrawInfo.clients[n].name = "수령자";
      InputDrawInfo.clients[n].size = 0;
      InputDrawInfo.clients[n].bN = null;
      InputDrawInfo.clients[n].pN = null;
      return;
    } else {
      System.out.println("정보가 틀립니다.수령하실수 없습니다.");
      InputDrawInfo.clients[n].id = null;
      InputDrawInfo.clients[n].name = "미수령자";
      InputDrawInfo.clients[n].size = 0;
      InputDrawInfo.clients[n].bN = null;
      InputDrawInfo.clients[n].pN = null;
      System.out.println("응모자 정보를 삭제겠습니다.");
      return;
    }
  }
}