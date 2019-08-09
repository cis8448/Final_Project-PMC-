package com.example.finalproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Path;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class AndroidController {
    ArrayList<MemberBean> allmem;

    Activity MainAct;
    Activity SubAct;
    GetServer Server = new GetServer();
    int number;
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
        //로그인페이지 이동
        if(state.equals("LoginOpen")){
            Intent Open = new Intent("com.example.finalproject.Login");
            activity.startActivity(Open);
        }
        //회원가입 선택 페이지로 이동
        if(state.equals("signUpSelectOpen")){
            Intent Open = new Intent("com.example.finalproject.SignUpSelect");
            activity.startActivity(Open);
        }
        //카카오로 회원가입버튼을 눌렀을 경우 페이지 이동
        if(state.equals("EasySignUpOpen")){
            Intent Open = new Intent("com.example.finalproject.EasySignUp");
            activity.startActivity(Open);
        }
        if(state.equals("SignUpOpen")){
            Intent Open = new Intent("com.example.finalproject.SignUp");
            activity.startActivity(Open);
        }
        if(state.equals("Memberidoverlap")){

            if(Server.MemberIdOverLap("Memberidoverlap",activity)){
                Toast.makeText(activity, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                if(number == 0) {
                    number++;
                    ((SignUp)activity).count++;
                    if(((SignUp)activity).count ==2){
                        ((SignUp)activity).SignUpNext.setEnabled(true);
                    }
                }
            }else{
                Toast.makeText(activity, "아이디를 사용하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                if(number == 1) {
                    number--;
                    ((SignUp)activity).count--;
                    if(((SignUp)activity).count ==1){
                        ((SignUp)activity).SignUpNext.setEnabled(false);
                    }
                }
            }
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
            activity.startActivity(PcSearch);
        }

        //1:1 문의
        if (state.equals("Inquiry")){
            Intent Inquiry = new Intent("com.example.finalproject.PcRoomInquire");
            activity.startActivity(Inquiry);
        }

    }
}
