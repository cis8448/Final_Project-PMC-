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
        switch (view.getId()) {
            case R.id.dbtn1:
                andcon.sub(SeatDetail.this, "Reservationopen");
                break;
            case R.id.dbtn2:
                finish();
                break;
        }
    }
}