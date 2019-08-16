package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();
    TextView rtx1, rtx2, rtx3;
    Button rbtn1, rbtn2, rbtn3;
    SeatBean sb;
    TimePicker tp1;
    String confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        rtx1 = findViewById(R.id.rtx1);
        rtx2 = findViewById(R.id.rtx2);
        rtx3 = findViewById(R.id.rtx3);
        rbtn1 = findViewById(R.id.rbtn1);
        rbtn2 = findViewById(R.id.rbtn2);
        rbtn3 = findViewById(R.id.rbtn3);
        tp1 = findViewById(R.id.tp1);
        //서버랑 연결해서 예약취소뜨게하기
//        andcon.sub(this,"reserveConfirm");
//        if(confirm.equals("1")){
//            rbtn1.setText("예약취소");
//        }else{
//            rbtn1.setText("예약하기");
//        }
//        andcon.sub(this,"reserveSelect");


        if (andcon.sb.getM_id() != null&&andcon.sb.getM_id().equals(andcon.member.getM_id())) {
            rbtn1.setText("예약취소");
        }
        if (andcon.sb.getS_noreserve().equals("불가  ") || andcon.sb.getS_state().equals("예약  ") || andcon.sb.getS_state().equals("사용  ")) {
            rbtn1.setEnabled(false);
            if (andcon.sb.getM_id().equals(andcon.member.getM_id())) {
                rbtn1.setEnabled(true);
            }
        }


        rtx1.setText("예약자 : " + andcon.member.getM_id());
        rtx2.setText("예약 선택 좌석 : " + andcon.sb.getS_name() + "번 좌석");
        rtx3.setText(andcon.sb.getM_time());

        long now = System.currentTimeMillis();
        Date date = new Date(now);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//현재시간 (예약할때)
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        final String getTime = sdf.format(date);
        final String getTime1 = sdf1.format(date);

        rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rbtn1.getText().equals("예약하기")) {
                    andcon.map.put("s_state", "예약");
                    andcon.map.put("s_m_id", andcon.member.getM_id());
                    andcon.map.put("u_s_id", andcon.sb.getS_id());
                    andcon.map.put("u_code", 0 + "");
                    andcon.map.put("u_cate", 1 + "");
                    andcon.map.put("u_start", getTime + " " + tp1.getHour() + ":" + tp1.getMinute());
                    andcon.sub(Reservation.this, "reserve");

                } else {
                    andcon.map.put("s_state", "대기");
                    andcon.map.put("s_m_id", andcon.member.getM_id());
                    andcon.map.put("u_s_id", andcon.sb.getS_id());
                    andcon.map.put("u_code", 0 + "");
                    andcon.map.put("u_cate", 2 + "");
                    andcon.map.put("u_start", getTime1);
                    andcon.sub(Reservation.this, "reserveDelete");

                }
            }
        });
        rbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                andcon.sub(Reservation.this, "SeatDetailOpen");
            }
        });
        rbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
