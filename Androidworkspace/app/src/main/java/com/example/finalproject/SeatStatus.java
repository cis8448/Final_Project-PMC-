package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SeatStatus extends AppCompatActivity {


    public Bitmap[] pictures;
    AndroidController andcon = AndroidController.getInstance();
    DrawerLayout DL;
    ImageButton btn1, alarm, info;
    ImageView img1;
    LinearLayout scroll;
    TextView tx1;
    Button loginbtn, logoutbtn;
    ListView list1;
    ArrayList<SeatBean> arSeat;

    SeatAdapter seatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_status);
        DL = findViewById(R.id.drawlay);
        btn1 = findViewById(R.id.btn1);
        scroll = findViewById(R.id.scroll);
        tx1 = findViewById(R.id.tx1);
        loginbtn = findViewById(R.id.loginbtn);
        logoutbtn = findViewById(R.id.logoutbtn);
        info = findViewById(R.id.info);
        img1 = findViewById(R.id.img1);
        list1 = findViewById(R.id.list1);

        //메뉴버튼 클릭시 메뉴창 출력
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DL.openDrawer(Gravity.LEFT);
            }
        });

        andcon.sub(this, "GetPicture2");
        img1.setImageBitmap(pictures[0]);
        andcon.sub(this, "GetSeatList");
        seatAdapter = new SeatAdapter(arSeat);
        list1.setAdapter(seatAdapter);
        tx1.setText(andcon.UpdateMypcs.getP_name() + " 피시방 입니다");
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                andcon.sb = arSeat.get(i);
                andcon.sb.setS_name(i + "");
                finish();
                SeatDetailOpen(view);


            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    //비로그인시 메뉴 클릭 -> 로그인하러가기 클릭시 로그인액티비티 출력
    public void LoginGo(View view) {

        andcon.sub(this, "LoginOpen");

    }

    public void LogOut(View view) {


        andcon.sub(this, "LogOut");

    }


    //세팅 버튼
    public void btnSetting(View view) {
        andcon.sub(this, "btnSetting");
    }


    //홈으로 가기 버튼 처리
    public void btnHome(View view) {
        andcon.sub(this, "btnHome");
    }

    //전체 공지사항 버튼
    public void Notice(View view) {
        andcon.sub(this, "Notice");
    }


    //내 정보 버튼 처리
    public void btnMyInfo(View view) {
        andcon.sub(this, "btnMyInfo");
    }

    //퀵 메뉴 설정
    public void btnQuick(View view) {
        andcon.sub(this, "btnQuick");
    }

    //가입한 피시방
    public void btnMyPc(View view) {
        andcon.sub(this, "btnMyPc");
    }

    //좌석현황
    public void SeatState(View view) {
        andcon.sub(this, "SeatState");
    }

    //상품주문
    public void ProductOrder(View view) {
        andcon.sub(this, "ProductOrder");
    }

    //pc방 찾기
    public void PcSearch(View view) {
        andcon.sub(this, "PcSearch");
    }

    //1:1문의
    public void Inquiry(View view) {
        andcon.sub(this, "Inquiry");
    }

    //좌석 예약
    public void SeatDetailOpen(View view) {
        andcon.sub(this, "SeatDetailOpen");
    }


    public class SeatAdapter extends BaseAdapter {
        ArrayList<SeatBean> arSeats;

        SeatAdapter(ArrayList<SeatBean> list) {
            arSeats = list;

        }


        @Override
        public int getCount() {
            return arSeats.size();
        }

        @Override
        public Object getItem(int i) {
            return arSeats.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            Context context = viewGroup.getContext();
            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.seatlist, viewGroup, false);
            }


            TextView seatlist_tx1 = v.findViewById(R.id.seatlist_tx1);
            TextView seatlist_tx2 = v.findViewById(R.id.seatlist_tx2);
            TextView seatlist_tx3 = v.findViewById(R.id.seatlist_tx3);

            seatlist_tx1.setText(i + "번 좌석");
            seatlist_tx2.setText("상태 : " + arSeats.get(i).getS_state());
            seatlist_tx3.setText("예약 : " + arSeats.get(i).getS_noreserve());

            return v;
        }
    }

}
