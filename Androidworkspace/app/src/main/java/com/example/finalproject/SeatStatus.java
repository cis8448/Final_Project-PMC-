package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class SeatStatus extends AppCompatActivity {


    public Bitmap[] pictures;
    AndroidController andcon = AndroidController.getInstance();
    DrawerLayout DL;
    ImageButton btn1,alarm,info;
    ImageView img1;
    LinearLayout scroll,mainlow2;
    TextView mainlow1;
    Button loginbtn,logoutbtn;
    ListView list1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_status);
        DL = findViewById(R.id.drawlay);
        btn1 = findViewById(R.id.btn1);
        scroll = findViewById(R.id.scroll);
        mainlow2 = findViewById(R.id.mainlow2);
        mainlow1 = findViewById(R.id.mainlow1);
        loginbtn =findViewById(R.id.loginbtn);
        logoutbtn = findViewById(R.id.logoutbtn);
        alarm = findViewById(R.id.alarm);
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
        String id = "test2";
        if(pictures == null) {
            andcon.sub2(this, "GetPicture2",id);
            img1.setImageBitmap(pictures[0]);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    //비로그인시 메뉴 클릭 -> 로그인하러가기 클릭시 로그인액티비티 출력
    public void LoginGo(View view) {

        andcon.sub(this,"LoginOpen");

    }

    public void LogOut(View view){


        andcon.sub(this,"LogOut");

    }



    //세팅 버튼
    public void btnSetting(View view){
        andcon.sub(this,"btnSetting");
    }


    //홈으로 가기 버튼 처리
    public void btnHome(View view){
        andcon.sub(this,"btnHome");
    }

    //전체 공지사항 버튼
    public void Notice(View view){
        andcon.sub(this,"Notice");
    }


    //내 정보 버튼 처리
    public void btnMyInfo(View view){
        andcon.sub(this,"btnMyInfo");
    }

    //퀵 메뉴 설정
    public void btnQuick(View view){
        andcon.sub(this,"btnQuick");
    }

    //가입한 피시방
    public void btnMyPc(View view){
        andcon.sub(this,"btnMyPc");
    }

    //좌석현황
    public void SeatState(View view){
        andcon.sub(this,"SeatState");
    }
    //상품주문
    public void ProductOrder(View view){
        andcon.sub(this,"ProductOrder");
    }

    //pc방 찾기
    public void PcSearch(View view){
        andcon.sub(this,"PcSearch");
    }

    //1:1문의
    public void Inquiry(View view){
        andcon.sub(this,"Inquiry");
    }

}
