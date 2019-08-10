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
    public ArrayList<MyPcBean> Mypcs;
    public MemberBean member = new MemberBean();
    public MyPcBean mypc = new MyPcBean();


    Activity MainAct;
    Activity SubAct;


    int number;
    int easynumber;

    GetServer2 server2 = new GetServer2();


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
    public void sub2(Activity activity,String state,String id){
        if(state.equals("GetPicture2")){
            ((SeatStatus)activity).pictures =server2.GetServerPicture(activity,id);
        }
    }

    public void sub(Activity activity, String state){
        //사진 가져오기
        if(state.equals("GetPicture")){
            GetServer Server = new GetServer();
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
        //회원 가입 화면 열기
        if(state.equals("SignUpOpen")){
            Intent Open = new Intent("com.example.finalproject.SignUp");
            setActivity2(activity);
            activity.startActivity(Open);
        }
        //간편 회원가입 화면 열기
        if(state.equals("EasySignUpOpen")){
            Intent Open = new Intent("com.example.finalproject.EasySignUp");
            setActivity2(activity);
            activity.startActivity(Open);
        }
        //아이디 중복 확인
        if(state.equals("Memberidoverlap")){
            GetServer Server = new GetServer();
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
        //아이디 중복 확인
        if(state.equals("Memberidoverlap")){
            GetServer Server = new GetServer();
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
        //이지로그인
        if(state.equals("EasyMemberidoverlap")){
            GetServer Server = new GetServer();
            if(Server.EazyMemberIdOverLap("Memberidoverlap",activity)){
                Toast.makeText(activity, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                if(number == 0) {
                    easynumber++;
                    ((EasySignUp)activity).count++;
                    if(((EasySignUp)activity).count ==2){
                        ((EasySignUp)activity).SignUpNext.setEnabled(true);
                    }
                }
            }else{
                Toast.makeText(activity, "아이디를 사용하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                if(number == 1) {
                    easynumber--;
                    ((EasySignUp)activity).count--;
                    if(((EasySignUp)activity).count ==1){
                        ((EasySignUp)activity).SignUpNext.setEnabled(false);
                    }
                }
            }
        }
        //회원가입 처리
        if(state.equals("InsertMember")){
            GetServer Server = new GetServer();
            if(Server.GetMemberSignUp("InsertMember",activity)) {
                Toast.makeText(activity, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show();
                member = null;
                MainAct = null;
                activity.finish();
                SubAct.finish();
            }else{
                Toast.makeText(activity, "회원가입에 실패했습니다 다시 시도해 주세요", Toast.LENGTH_SHORT).show();
            }
        }
        //로그인 처리
         if(state.equals("MemberLogin")){
             GetServer Server = new GetServer();
            if(Server.MemberLogin(state,activity)){
                Toast.makeText(activity, "로그인에 성공했습니다." , Toast.LENGTH_SHORT).show();
                activity.finish();
                sub(MainAct,"MainActLoginSetting");
            }else{
                Toast.makeText(activity, "가입한 정보가 없습니다.", Toast.LENGTH_SHORT).show();
            }
         }
         //간편 로그인 처리
        if(state.equals("EazyLosin")){
            GetServer Server = new GetServer();
            if(Server.EazyLogin(member.getM_kakaoid(),state,activity)){
                Toast.makeText(activity, "로그인에 성공했습니다." , Toast.LENGTH_SHORT).show();
                activity.finish();
                sub(MainAct,"MainActLoginSetting");
            }else{
                Toast.makeText(activity, "카카오로 계정으로 가입한 정보가 없습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        //휴대폰 인증 화면 오픈
        if(state.equals("certificationOpen")){
            Intent Open = new Intent("com.example.finalproject.Certification");
            setActivity2(activity);
            activity.startActivity(Open);
        }
        //랜덤값을 카카오 메세지로 보내기
        if(state.equals("send")){
            //카카오메세지보내기
        }
        //인증 완료 아이디 불러오기
        if(state.equals("getIdOpen")){
            GetServer Server = new GetServer();
            Intent Open = new Intent("com.example.finalproject.MyIdCheck");
            if(Server.MemberGetId(state,activity,member.getM_phone())) {
                activity.startActivity(Open);
                activity.finish();
            }else{
                Toast.makeText(activity, "아이디 찾기에 실패했습니다. 다시 시도해주세요", Toast.LENGTH_SHORT).show();
            }
        }
        // 비밀번호 변경 페이지 오픈
        if(state.equals("PassUpdateOpen")){
            Intent Open = new Intent("com.example.finalproject.PassUpdate");
            activity.startActivity(Open);
            activity.finish();
        }
        //비밀번호 변경
        if(state.equals("UpdatePass")){
            GetServer Server = new GetServer();
            if(Server.UpdatePass(state,activity,member.getM_id(),member.getM_pass())){
                Toast.makeText(activity, "비밀번호가 성공적으로 변경되었습니다.", Toast.LENGTH_SHORT).show();
                activity.finish();
            }else{
                Toast.makeText(activity, "비밀번호 변경 실패 다시 시도해 주세요", Toast.LENGTH_SHORT).show();
            }
        }


        //메인화면 로그인 처리
        if(state.equals("MainActLoginSetting")){

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
            GetServer Server = new GetServer();
            Intent btnMyPc = new Intent("com.example.finalproject.WhenPcroom");
            if(Server.MyPcGetName(state,activity,mypc.getSP_m_id())) {
                activity.startActivity(btnMyPc);
                activity.finish();
            }else{

            }




        }

        //좌석 현황
        if (state.equals("SeatState")){
            Intent SeatState = new Intent("com.example.finalproject.SeatStatus");
            activity.startActivity(SeatState);
        }

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
        if(state.equals("GetPicture")){

        }
        if(state.equals("getMypcAdapter")){
            MyPcRoomAdapterSetting mypc = new MyPcRoomAdapterSetting(Mypcs);
            ((WhenPcroom)activity).adapter = mypc.mypcSearch();
        }

    }
}
