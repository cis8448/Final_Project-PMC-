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
    GetServer Server = new GetServer();

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
      //사진 가져오기
        if(state.equals("GetPicture")){
            ((MainActivity)activity).pictures = Server.GetServerPicture(activity);
        }
        if(state.equals("SettingPictuer")){
            ((MainActivity)activity).pictures = Server.pictures;
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
            Intent btnMyPc = new Intent("com.example.finalproject.WhenPcroom");
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
            ((MainActivity)activity).address = Server.GetServerAddress(activity);
            activity.startActivity(PcSearch);
        }

        //1:1 문의
        if (state.equals("Inquiry")){
            Intent Inquiry = new Intent("com.example.finalproject.PcRoomInquire");
            activity.startActivity(Inquiry);
        }

    }
}
