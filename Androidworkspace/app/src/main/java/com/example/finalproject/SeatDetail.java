package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SeatDetail extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();
    SeatBean sb = andcon.sb;
    String spec = sb.getS_spec();
    String gc;
    String cpu;
    String mo;
    Button dbtn1, dbtn2;
    TextView dtx1, dtx2, dtx3, dtx0;
    JsonObject jsons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_detail);
        dbtn1 = findViewById(R.id.dbtn1);
        dbtn2 = findViewById(R.id.dbtn2);
        dtx1 = findViewById(R.id.dtx1);
        dtx2 = findViewById(R.id.dtx2);
        dtx3 = findViewById(R.id.dtx3);
        dtx0 = findViewById(R.id.dtx0);


        dtx0.setText(sb.getS_name() + "번 좌석");
        if (andcon.sb.getM_id() != null && andcon.sb.getM_id().equals(andcon.member.getM_id())) {
            dbtn1.setText("예약취소");
        }

        if (andcon.sb.getS_noreserve().equals("불가  ") || andcon.sb.getS_state().equals("예약  ") || andcon.sb.getS_state().equals("사용  ")) {
            dbtn1.setEnabled(false);
            if (andcon.sb.getM_id() != null && andcon.sb.getM_id().equals(andcon.member.getM_id())) {
                dbtn1.setEnabled(true);
            }
        }
        JsonParser parser = new JsonParser();

        try {
            jsons = (JsonObject) parser.parse(sb.getS_spec());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            gc = jsons.get("a").getAsString();
        } catch (Exception e) {
            gc = "스펙정보가 없습니다";
        }
        try {
            cpu = jsons.get("b").getAsString();
        } catch (Exception e) {
            cpu = "스펙정보가 없습니다";
        }
        try {
            mo = jsons.get("c").getAsString();
        } catch (Exception e) {
            mo = "스펙정보가 없습니다";
        }
        Log.e("spec", gc);
        Log.e("spec", cpu);
        Log.e("spec", mo);
        dtx1.setText("그래픽 카드 : " + gc);
        dtx2.setText("CPU : " + cpu);
        dtx3.setText("모니터 : " + mo);

    }

    public void dbtn(View view) {
        long now = System.currentTimeMillis();
        Date date = new Date(now);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//현재시간 (예약할때)
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        final String getTime = sdf.format(date);
        final String getTime1 = sdf1.format(date);
        switch (view.getId()) {
            case R.id.dbtn1:
                if (dbtn1.getText().equals("예약하기")) {
                    andcon.sub(SeatDetail.this, "Reservationopen");
                } else {
                    andcon.map.put("s_state", "대기");
                    andcon.map.put("s_m_id", andcon.member.getM_id());
                    andcon.map.put("u_s_id", andcon.sb.getS_id());
                    andcon.map.put("u_code", 0 + "");
                    andcon.map.put("u_cate", 3 + "");
                    andcon.map.put("u_start", andcon.map.get("u_start"));
                    andcon.sub(SeatDetail.this, "reserveDelete");
                }

                break;
            case R.id.dbtn2:
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}