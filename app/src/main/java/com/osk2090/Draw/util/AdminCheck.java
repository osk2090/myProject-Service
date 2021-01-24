package com.osk2090.Draw.util;

import com.osk2090.Draw.ADMIN_ROOM.AdminInfo;
import com.osk2090.Draw.Admin;

public class AdminCheck {

    public static boolean checkResult() {
        Admin.myAdminId = Prompt.promptString("관리자id: ");
        Admin.myAdminPw = Prompt.promptInt("관리자pw: ");

        if (Admin.myAdminId.equals(AdminInfo.AdminID) && Admin.myAdminPw == AdminInfo.AdminPW) {
            System.out.println("관리자님 환영합니다.");
            return true;
        }
        System.out.println("관리자의 아이디와 비밀번호를 확인해주세요.");
        return false;
    }
}