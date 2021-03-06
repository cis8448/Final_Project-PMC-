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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    public Bitmap[] pictures;
    public String address;





    AndroidController andcon = AndroidController.getInstance();
    DrawerLayout DL;
    ImageButton btn1;
    ImageView pcroomimg1;
    public LinearLayout scroll,mainlow2;
    public TextView mainlow1,pointtxt,nametxt,minipoint;
    ImageButton alarm,info;
    public Button loginbtn,logoutbtn;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DL = findViewById(R.id.drawlay);
        btn1 = findViewById(R.id.btn1);
        scroll = findViewById(R.id.scroll);

        mainlow1 = findViewById(R.id.mainlow1);
        loginbtn =findViewById(R.id.loginbtn);
        logoutbtn = findViewById(R.id.logoutbtn);
        info = findViewById(R.id.info);

        nametxt= findViewById(R.id.nametxt);
        pcroomimg1 = findViewById(R.id.pcroomimg2);
        minipoint =findViewById(R.id.minipoint);
        andcon.setActivity(this);

        //메뉴버튼 클릭시 메뉴창 출력
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DL.openDrawer(Gravity.LEFT);
            }
        });
        UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
            @Override
            public void onCompleteLogout() {

            }
        });

        if(pictures == null) {
            andcon.sub(this, "GetPicture");
         pcroomimg1.setImageBitmap(pictures[1]);
        }


    }

    //비로그인시 메뉴 클릭 -> 로그인하러가기 클릭시 로그인액티비티 출력
    public void LoginGo(View view) {

        andcon.sub(this,"LoginOpen");

    }

    public void LogOut(View view){
        andcon.member = null;
        andcon.member = new MemberBean();
        andcon.sub(this,"logout");
    }


    //버튼 클릭 -> PC방 이미지 변경 처리
    public void imgbtn(View view){
        switch (view.getId()){
            case R.id.rightbtn:
                count++;
                if(count > 2){
                    count = 0;
                }
                pcroomimg1.setImageBitmap(pictures[count]);
                break;

            default:
                count--;
                if(count ==-1){
                    count=2;
                }
                pcroomimg1.setImageBitmap(pictures[count]);
                break;
        }



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