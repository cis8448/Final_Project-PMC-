package com.example.finalproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Path;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AndroidController {
    Map<String, String> map = new HashMap<>();
    public ArrayList<SeatBean> seats = new ArrayList<>();
    ArrayList<MemberBean> allmem;
    public ArrayList<MyPcBean> Mypcs;
    public MyPcBean UpdateMypcs;
    public MemberBean member = new MemberBean();
    public boolean Check;
    public MyPcBean mypc = new MyPcBean();
    ArrayList<PcRoomBean> allpcroom;
    public String selectsido;
    SeatBean sb = new SeatBean();
   // Map map;

    Activity MainAct;
    Activity SubAct;


    int number;
    int easynumber;




    static AndroidController androidcontroller;

    private AndroidController() {

    }

    public static AndroidController getInstance() {
        if (androidcontroller == null) {
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

    public static void cutComtroll() {
        androidcontroller = null;
    }


    public void sub(Activity activity, String state) {

        //사진 가져오기
        if (state.equals("GetPicture")) {
            GetServer Server = new GetServer();
            ((MainActivity) activity).pictures = Server.GetServerPicture(activity);
        }
        //로그인페이지 이동
        if (state.equals("LoginOpen")) {
            Intent Open = new Intent("com.example.finalproject.Login");
            activity.startActivity(Open);
        }
        //회원가입 선택 페이지로 이동
        if (state.equals("signUpSelectOpen")) {
            Intent Open = new Intent("com.example.finalproject.SignUpSelect");
            activity.startActivity(Open);
        }
        //회원 가입 화면 열기
        if (state.equals("SignUpOpen")) {
            Intent Open = new Intent("com.example.finalproject.SignUp");
            setActivity2(activity);
            activity.startActivity(Open);
        }
        //간편 회원가입 화면 열기
        if (state.equals("EasySignUpOpen")) {
            Intent Open = new Intent("com.example.finalproject.EasySignUp");
            setActivity2(activity);
            activity.startActivity(Open);
        }
        //아이디 중복 확인
        if (state.equals("Memberidoverlap")) {
            GetServer Server = new GetServer();
            if (Server.MemberIdOverLap("Memberidoverlap", activity)) {
                Toast.makeText(activity, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                if (number == 0) {
                    number++;
                    ((SignUp) activity).count++;
                    if (((SignUp) activity).count == 2) {
                        ((SignUp) activity).SignUpNext.setEnabled(true);
                    }
                }
            } else {
                Toast.makeText(activity, "아이디를 사용하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                if (number == 1) {
                    number--;
                    ((SignUp) activity).count--;
                    if (((SignUp) activity).count == 1) {
                        ((SignUp) activity).SignUpNext.setEnabled(false);
                    }
                }
            }
        }
        //아이디 중복 확인
        if (state.equals("Memberidoverlap")) {
            GetServer Server = new GetServer();
            if (Server.MemberIdOverLap("Memberidoverlap", activity)) {
                Toast.makeText(activity, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                if (number == 0) {
                    number++;
                    ((SignUp) activity).count++;
                    if (((SignUp) activity).count == 2) {
                        ((SignUp) activity).SignUpNext.setEnabled(true);
                    }
                }
            } else {
                Toast.makeText(activity, "아이디를 사용하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                if (number == 1) {
                    number--;
                    ((SignUp) activity).count--;
                    if (((SignUp) activity).count == 1) {
                        ((SignUp) activity).SignUpNext.setEnabled(false);
                    }
                }
            }
        }
        //이지로그인
        if (state.equals("EasyMemberidoverlap")) {
            GetServer Server = new GetServer();
            if (Server.EazyMemberIdOverLap("Memberidoverlap", activity)) {
                Toast.makeText(activity, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                if (number == 0) {
                    easynumber++;
                    ((EasySignUp) activity).count++;
                    if (((EasySignUp) activity).count == 2) {
                        ((EasySignUp) activity).SignUpNext.setEnabled(true);
                    }
                }
            } else {
                Toast.makeText(activity, "아이디를 사용하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                if (number == 1) {
                    easynumber--;
                    ((EasySignUp) activity).count--;
                    if (((EasySignUp) activity).count == 1) {
                        ((EasySignUp) activity).SignUpNext.setEnabled(false);
                    }
                }
            }
        }
        //회원가입 처리
        if (state.equals("InsertMember")) {
            GetServer Server = new GetServer();
            if (Server.GetMemberSignUp("InsertMember", activity)) {
                Toast.makeText(activity, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show();
                member = null;
                MainAct = null;
                activity.finish();
                SubAct.finish();
            } else {
                Toast.makeText(activity, "회원가입에 실패했습니다 다시 시도해 주세요", Toast.LENGTH_SHORT).show();
            }
        }
        //로그인 처리
        if (state.equals("MemberLogin")) {
            GetServer Server = new GetServer();
            if (Server.MemberLogin(state, activity)) {
                Toast.makeText(activity, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();
                activity.finish();
                sub(MainAct, "MainActLoginSetting");
            } else {
                Toast.makeText(activity, "가입한 정보가 없습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        //간편 로그인 처리
        if (state.equals("EazyLosin")) {
            GetServer Server = new GetServer();
            if (Server.EazyLogin(member.getM_kakaoid(), state, activity)) {
                Toast.makeText(activity, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();
                activity.finish();
                sub(MainAct, "MainActLoginSetting");
            } else {
                Toast.makeText(activity, "카카오로 계정으로 가입한 정보가 없습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        //휴대폰 인증 화면 오픈
        if (state.equals("certificationOpen")) {
            Intent Open = new Intent("com.example.finalproject.Certification");
            setActivity2(activity);
            activity.startActivity(Open);
        }
        //랜덤값을 카카오 메세지로 보내기
        if (state.equals("send")) {
            GetServer Server = new GetServer();
            Check = Server.GetMyInfo(state, activity, member.getM_phone());
        }
        //인증 완료 아이디 불러오기
        if (state.equals("getIdOpen")) {
            GetServer Server = new GetServer();
            if (Server.MemberGetId(state, activity, member.getM_phone())) {
                Intent Open = new Intent("com.example.finalproject.MyIdCheck");
                activity.startActivity(Open);
            } else {
                Toast.makeText(activity, "아이디 찾기에 실패했습니다. 다시 시도해주세요", Toast.LENGTH_SHORT).show();
            }
            activity.finish();
        }
        // 비밀번호 변경 페이지 오픈
        if (state.equals("PassUpdateOpen")) {
            Intent Open = new Intent("com.example.finalproject.PassUpdate");
            activity.startActivity(Open);
            activity.finish();
        }
        //비밀번호 변경
        if (state.equals("UpdatePass")) {
            GetServer Server = new GetServer();
            if (Server.UpdatePass(state, activity, member.getM_id(), member.getM_pass())) {
                Toast.makeText(activity, "비밀번호가 성공적으로 변경되었습니다.", Toast.LENGTH_SHORT).show();
                activity.finish();
            } else {
                Toast.makeText(activity, "비밀번호 변경 실패 다시 시도해 주세요", Toast.LENGTH_SHORT).show();
            }
        }
//        if(state.equals("getProductPicture")){
//            ((ProductList)activity).productpicture = Server.GetServerProductPicture(activity);
//        }


        //메인화면 로그인 처리
        if (state.equals("MainActLoginSetting")) {
            ((MainActivity) MainAct).mainlow2.setVisibility(View.VISIBLE);
            ((MainActivity) MainAct).mainlow1.setVisibility(View.GONE);
            ((MainActivity) MainAct).pointtxt.setText(member.getM_point());
            ((MainActivity) MainAct).loginbtn.setVisibility(View.GONE);
            ((MainActivity) MainAct).logoutbtn.setVisibility(View.VISIBLE);
            ((MainActivity) MainAct).nametxt.setText(member.getM_name() + "님");
            ((MainActivity) MainAct).minipoint.setText(member.getM_point() + "p");
            ((MainActivity) MainAct).scroll.setVisibility(View.VISIBLE);

        }
        //메뉴 버튼 처리
        //세팅
        if (state.equals("btnSetting")) {
            Intent btnSetting = new Intent("com.example.finalproject.Preferences");
            activity.startActivity(btnSetting);
        }

        //홈으로 가기
        if (state.equals("btnHome")) {
            Intent btnHome = new Intent("com.example.finalproject.MainActivity");
            activity.startActivity(btnHome);
        }


        //전체 공지사항
        if (state.equals("Notice")) {
            Intent Notice = new Intent("com.example.finalproject.PcRoomNotice");
            activity.startActivity(Notice);
        }


        //내 정보 버튼 처리
        if (state.equals("btnMyInfo")) {
            Intent btnMyInfo = new Intent("com.example.finalproject.MyInfo");
            activity.startActivity(btnMyInfo);
        }

        //퀵 메뉴 설정
        if (state.equals("btnQuick")) {
            Intent btnQuick = new Intent("com.example.finalproject.QuickMenuSelect");
            activity.startActivity(btnQuick);
        }


        //가입한 피시방
        if (state.equals("btnMyPc")) {
            GetServer Server = new GetServer();
            Intent btnMyPc = new Intent("com.example.finalproject.WhenPcroom");
            if (Server.MyPcGetName(state, activity, member.getM_id())) {
                activity.startActivity(btnMyPc);
            }

        }


        //좌석 현황
        if (state.equals("SeatState")) {
            Intent SeatState = new Intent("com.example.finalproject.SeatStatus");
            activity.startActivity(SeatState);
        }

        //상품 주문
        if (state.equals("ProductOrder")) {
            Intent ProductOrder = new Intent("com.example.finalproject.ProductList");
            activity.startActivity(ProductOrder);
        }
        //상품 주문 -> 장바구니
        if (state.equals("ProductBasket")) {
            Intent ProductOrder = new Intent("com.example.finalproject.ProductBasket");
            activity.startActivity(ProductOrder);
        }

        //pc방 찾기
        if (state.equals("PcSearch")) {
            Intent PcSearch = new Intent("com.example.finalproject.PcRoomGPS");
            activity.startActivity(PcSearch);
        }

        //1:1 문의
        if (state.equals("Inquiry")) {
            Intent Inquiry = new Intent("com.example.finalproject.PcRoomInquire");
            activity.startActivity(Inquiry);
        }
        if (state.equals("GetPicture")) {

        }
        if (state.equals("bookmarkUp")) {
            GetServer Server = new GetServer();
            String info = Server.bookmarkup(state, activity);
            if (info.equals("1")) {
                Toast.makeText(activity, "북마크 등록에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "북마크 등록해제에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        }
        if (state.equals("PcDetileOpen")) {
            Intent Open = new Intent("com.example.finalproject.PcRoomInfo");
            activity.startActivity(Open);
            activity.finish();
        }
        if (state.equals("Seatsearch")) {
            GetServer Server = new GetServer();
            ((PcRoomInfo) activity).seats.setText(Server.Seatsearch(state, activity));
        }
        if (state.equals("pcjoinDelete")) {
            GetServer Server = new GetServer();
            Check = Server.pcjonDelete(state, activity);
        }
        if(state.equals("sido")){
            GetServer Server = new GetServer();
            ArrayList<String> sido = Server.Getsido(state,activity);
            Listsetting listsetting = new Listsetting(sido,1);
            ((PcRoomGPS)activity).pcadapterSet = listsetting.pcRoomListSetting();
        }
        if(state.equals("DongListSet")){
            GetServer Server = new GetServer();
            ArrayList<String> dongs = Server.DongListSet(state,activity,selectsido);
            if(dongs ==null) {
                dongs= new ArrayList<>();
            }

            Listsetting listsetting = new Listsetting(dongs,1);
            ((PcRoomGPS)activity).dongadapter = listsetting.pcRoomListSetting();
        }
        if(state.equals("dongPcList")){
            GetServer Server = new GetServer();
            Intent btnMyPc = new Intent("com.example.finalproject.WhenPcroom");
            if (Server.dongPcList(state, activity,selectsido)) {
                activity.startActivity(btnMyPc);

            }
        }

        if(state.equals("reserveDelete")){
            GetServer server = new GetServer();
            if(server.reserveDelete("reserveDelete",activity)){
                Toast.makeText(activity, "예약취소 완료!", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(activity, "예약취소 실패!", Toast.LENGTH_SHORT).show();
            }
        }

        if(state.equals("reserveConfirm")){
            GetServer server = new GetServer();
            if(server.reserveConfirm("reserveConfirm",activity)){
                ((Reservation) activity).confirm="1";
            }else{
                ((Reservation) activity).confirm="0";
            }
        }
        if (state.equals("reserve")) {
            GetServer server2 = new GetServer();
            if (server2.SetReserve("reserve", activity)) {
                Toast.makeText(activity, "예약완료!", Toast.LENGTH_SHORT).show();
                ((Reservation) activity).finish();
            } else {
                Toast.makeText(activity, "예약실패!", Toast.LENGTH_SHORT).show();
            }
        }
        if (state.equals("Reservationopen")) {
            Intent Open = new Intent("com.example.finalproject.Reservation");
            setActivity2(activity);
            activity.startActivity(Open);
        }
        //좌석 배치도 불러오기
        if (state.equals("GetPicture2")) {
            GetServer server2 = new GetServer();
            ((SeatStatus) activity).pictures = server2.GetServerPicture2(activity);
        }
        //좌석 리스트 불러오기
        if (state.equals("GetSeatList")) {
            GetServer server2 = new GetServer();
            seats = server2.GetSeatList(activity);
            uselogBean use = server2.Getuselog("GetUseLog",activity);
            ((SeatStatus) activity).arSeat = seats;
        }

        if (state.equals("SeatDetailOpen")) {
            Intent Open = new Intent("com.example.finalproject.SeatDetail");
            activity.startActivity(Open);
        }
        if(state.equals("pcjoinbtn")){
            GetServer Server = new GetServer();
            if(Server.pcjoinbtn("pcjoinbtn",activity)){
                for(int i = 0;i < Mypcs.size(); i++){
                    if(Mypcs.get(i).getP_id().equals(UpdateMypcs.getP_id())&&
                            Mypcs.get(i).getST_m_id()==null){
                        Mypcs.set(i,UpdateMypcs);
                    }
                }
                ((PcRoomInfo)activity).info = UpdateMypcs;
                ((PcRoomInfo)activity).startbtn.setVisibility(View.VISIBLE);
                ((PcRoomInfo)activity).timetxt.setVisibility(View.VISIBLE);
                ((PcRoomInfo)activity).timetxt.setText("남은 시간 : " + UpdateMypcs.getSP_time());
                ((PcRoomInfo)activity).joinbtn.setText("충전하기");
                Toast.makeText(activity, "가입완료", Toast.LENGTH_SHORT).show();
            }
        }


    }

}
