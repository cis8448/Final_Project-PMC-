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


        //메뉴 버튼 처리
        //세팅
        if (state.equals("btnSetting")){
            Intent btnSetting = new Intent("com.example.finalproject.Preferences");
            activity.startActivity(btnSetting);
        }

        //홈으로 가기
        if (state.equals("btnHome")){
            Intent btnHome = new Intent("com.example.finalproject.MainActivity");
            activity.startActivity(btnHome);
        }


        //전체 공지사항
        if (state.equals("Notice")){
            Intent Notice = new Intent("com.example.finalproject.PcRoomNotice");
            activity.startActivity(Notice);
        }


        //내 정보 버튼 처리
        if (state.equals("btnMyInfo")){
            Intent btnMyInfo = new Intent("com.example.finalproject.MyInfo");
            activity.startActivity(btnMyInfo);
        }

        //퀵 메뉴 설정
        if (state.equals("btnQuick")){
            Intent btnQuick = new Intent("com.example.finalproject.QuickMenuSelect");
            activity.startActivity(btnQuick);
        }


        //가입한 피시방
        if (state.equals("btnMyPc")){
            Intent btnMyPc = new Intent("com.example.finalproject.PcRoomInfo");
            activity.startActivity(btnMyPc);
        }

        //좌석 현황


        //상품 주문
        if (state.equals("ProductOrder")){
            Intent ProductOrder = new Intent("com.example.finalproject.ProductList");
            activity.startActivity(ProductOrder);
        }

        //pc방 찾기
        if (state.equals("PcSearch")){
            Intent PcSearch = new Intent("com.example.finalproject.PcRoomGPS");
            activity.startActivity(PcSearch);
        }

        //1:1 문의
        if (state.equals("Inquiry")){
            Intent Inquiry = new Intent("com.example.finalproject.PcRoomInquire");
            activity.startActivity(Inquiry);
        }

    }
}
