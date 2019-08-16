package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class PcRoomGPS extends AppCompatActivity {

    public Listsetting.PcRoomAdapter pcadapterSet,dongadapter;
    public ListView ListView1, ListView2;

    PcRoomBean pcRoomBean = new PcRoomBean();

    AndroidController andcon = AndroidController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_room_gps);

        ListView1 = findViewById(R.id.ListView1);
        ListView2 = findViewById(R.id.ListView2);



        if(pcadapterSet == null){
            andcon.sub(this, "sido");
            ListView1.setAdapter(pcadapterSet);
        }



        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long l) {
                TextView txt = view.findViewById(R.id.sido);
                andcon.selectsido = txt.getText().toString();
                andcon.sub(PcRoomGPS.this,"DongListSet");
                ListView2.setAdapter(dongadapter);
                dongadapter.notifyDataSetChanged();
            }
        });
        ListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txt = view.findViewById(R.id.sido);
                andcon.selectsido = txt.getText().toString();
                andcon.sub(PcRoomGPS.this,"dongPcList");


            }
        });



    }


}

