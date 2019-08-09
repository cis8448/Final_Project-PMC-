package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

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

        getHashKey();
        //메뉴버튼 클릭시 메뉴창 출력
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DL.openDrawer(Gravity.LEFT);
            }
        });



    }
    private void getHashKey(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.e("Hash key", something);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("name not found", e.toString());
        }
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