package com.example.finalproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;

import java.util.ArrayList;

public class AndroidController {
    ArrayList<MemberBean> allmem;

    Activity MainAct;
    Activity SubAct;


    static AndroidController androidcontroller;

    private AndroidController(){

    }
    public static AndroidController getInstance() {
        if (androidcontroller == null){
            androidcontroller = new AndroidController();
        }
        return androidcontroller;
    }

    public void setActivity(Activity act) {
        MainAct = act;
    }//액티비티저장
    public void setActivity2(Activity act) {
        SubAct = act;
    }
    public static void cutComtroll(){
        androidcontroller = null;
    }
    public void sub(Activity activity, String state){


        // 메인 -> 로그인오픈
        if (state.equals("LoginOpen")){
            Intent LoginOpen = new Intent("com.example.finalproject.Login");
            activity.startActivity(LoginOpen);
        }
        if (state.equals("SignSelectOpen")){
            Intent SignSelectOpen = new Intent("com.example.finalproject.SignUpSelect");
            activity.startActivity(SignSelectOpen);
        }
    }
}
