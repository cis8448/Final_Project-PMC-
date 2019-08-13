package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PcRoomInfo extends AppCompatActivity {

    AndroidController andcon = AndroidController.getInstance();
    ImageView pcroomimg1;
    public TextView MyPcName,addr,hptxt,timetxt,seats;
    Button joinbtn;
    MyPcBean info =andcon.UpdateMypcs;
    PictureBean pictureBean = new PictureBean();
    Bitmap[] imgsrc;
    int count;
    ImageButton btn1;
    DrawerLayout DL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_room_info);


        MyPcName = findViewById(R.id.MyPcName);
        addr = findViewById(R.id.addr);
        hptxt = findViewById(R.id.hptxt);
        timetxt = findViewById(R.id.timetxt);
        seats = findViewById(R.id.seats);
        pcroomimg1 = findViewById(R.id.pcroomimg1);
        joinbtn = findViewById(R.id.joinbtn);
        btn1 =findViewById(R.id.btn1);
        andcon.setActivity(this);
        DL = findViewById(R.id.drawlay);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DL.openDrawer(Gravity.LEFT);
            }
        });


        if(info.getSP_m_id() !=null){
            joinbtn.setText("충전하기");
        }else{
            joinbtn.setText("가입하기");
        }
        if(info.getP_picture1() != null ||info.getP_picture2() != null || info.getP_picture3() != null) {
                pictureBean.setPicture1(info.getP_picture1());
                pictureBean.setPicture2(info.getP_picture2());
                pictureBean.setPicture3(info.getP_picture3());
                GetServer Server = new GetServer();
                imgsrc = Server.GetPictures(pictureBean);
                pcroomimg1.setImageBitmap(imgsrc[0]);
        }


        MyPcName.setText(info.getP_name());
        addr.setText(info.getP_sido() + info.getP_gugun() + info.getP_dong() + info.getP_addr());
        hptxt.setText(info.getP_phone());
        timetxt.setText("남은 시간 : " + info.getSP_time());
        andcon.sub(this,"Seatsearch");


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


    public void mypcpicture(View view){
        switch (view.getId()){
            case R.id.rightbtn:
                count++;
                if(count > 2){
                    count = 0;
                }
                pcroomimg1.setImageBitmap(imgsrc[count]);
            break;

        default:
            count--;
            if(count ==-1){
                count=2;
            }
            pcroomimg1.setImageBitmap(imgsrc[count]);
            break;
        }
    }


}
