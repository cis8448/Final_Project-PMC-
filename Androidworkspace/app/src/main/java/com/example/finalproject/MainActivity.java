package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

    AndroidController andcon = AndroidController.getInstance();
    DrawerLayout DL;
    ImageButton btn1;
    ImageView pcroomimg,pcroomimg1,pcroomimg2;
    LinearLayout scroll,mainlow2;
    TextView mainlow1;
    ImageButton alarm,info;

    Button loginbtn,logoutbtn;


    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DL = findViewById(R.id.drawlay);
        btn1 = findViewById(R.id.btn1);
        scroll = findViewById(R.id.scroll);
        mainlow2 = findViewById(R.id.mainlow2);
        mainlow1 = findViewById(R.id.mainlow1);
        loginbtn =findViewById(R.id.loginbtn);
        logoutbtn = findViewById(R.id.logoutbtn);
        alarm = findViewById(R.id.alarm);
        info = findViewById(R.id.info);

        int picture[] = new int[3];
        //메뉴버튼 클릭시 메뉴창 출력
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DL.openDrawer(Gravity.LEFT);
            }
        });
        andcon.sub(this,"GetPicture");


    }

    //비로그인시 메뉴 클릭 -> 로그인하러가기 클릭시 로그인액티비티 출력
    public void LoginGo(View view) {

        andcon.sub(this,"LoginOpen");


    }

    public void LogOut(View view){


        andcon.sub(this,"LogOut");


    }


    //버튼 클릭 -> PC방 이미지 변경 처리
    public void imgbtn(View view){
        pcroomimg =findViewById(R.id.pcroomimg);
        pcroomimg1 =findViewById(R.id.pcroomimg1);
        pcroomimg2 =findViewById(R.id.pcroomimg2);

        int index = count % 3;

        if (index == 0) {
            pcroomimg.setVisibility(View.VISIBLE);
            pcroomimg1.setVisibility(View.GONE);
            pcroomimg2.setVisibility(View.GONE);
        }
        if (index == 1) {
            pcroomimg.setVisibility(View.GONE);
            pcroomimg1.setVisibility(View.VISIBLE);
            pcroomimg2.setVisibility(View.GONE);
        }
        if (index == 2) {
            pcroomimg.setVisibility(View.GONE);
            pcroomimg1.setVisibility(View.GONE);
            pcroomimg2.setVisibility(View.VISIBLE);
        }

        count++;

    }
    //세팅 버튼
    public void btnSetting(View view){
        startActivity(new Intent(this, Preferences.class));
    }
    //홈으로 가기 버튼 처리
    public void btnHome(View view){
        startActivity(new Intent(this, MainActivity.class));
    }



    //내 정보 버튼 처리
    public void btnMyInfo(View view){
        startActivity(new Intent(this, MyInfo.class));
    }

    //퀵 메뉴 설정
    public void btnQuick(View view){
        startActivity(new Intent(this, QuickMenuSelect.class));
    }

    //가입한 피시방
    public void btnMyPc(View view){
        startActivity(new Intent(this, WhenPcroom.class));
    }





}