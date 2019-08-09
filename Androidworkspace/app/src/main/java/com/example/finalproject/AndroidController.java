package com.example.finalproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;

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
        // 로그인 -> 회원가입 버튼 클릭 -> 회원가입 선택창
        if (state.equals("SignUpSelectOpen")){
            Intent SignUpSelectOpen = new Intent("com.example.finalproject.SignUpSelect");
            activity.startActivity(SignUpSelectOpen);
        }
        // 회원가입 선택창 -> 피모씨 회원가입 오픈
        if (state.equals("SignUpOpen")){
            Intent SignUpOpen = new Intent("com.example.finalproject.SignUp");
            activity.startActivity(SignUpOpen);

        }
        if (state.equals("LogOut")){
            ((MainActivity)activity).mainlow2.setVisibility(View.GONE);
            ((MainActivity)activity).scroll.setVisibility(View.GONE);
            ((MainActivity)activity).logoutbtn.setVisibility(View.GONE);
            ((MainActivity)activity).alarm.setVisibility(View.GONE);
            ((MainActivity)activity).info.setVisibility(View.GONE);
            ((MainActivity)activity).loginbtn.setVisibility(View.VISIBLE);
            ((MainActivity)activity).mainlow1.setVisibility(View.VISIBLE);

        }

    }
}
