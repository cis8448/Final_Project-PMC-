package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Bitmap;
import android.os.Bundle;
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
    }

    public void mypcpicture(View view){
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
}
