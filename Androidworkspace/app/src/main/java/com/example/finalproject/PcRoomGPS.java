package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PcRoomGPS extends AppCompatActivity {

    public Listsetting.PcRoomAdapter pcadapterSet;
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
        }



        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), PcRoomGPS.class);

//                intent.putExtra("SIDO", data.get(position).getP_SIDO());
//                intent.putExtra("GUGUN", data.get(position).getP_GUGUN());
//                intent.putExtra("DONG", data.get(position).getP_DONG());
//                intent.putExtra("ADDR", data.get(position).getP_ADDR());
//
//
//                sido = findViewById(R.id.sido);
//                sido.setText(intent.getStringExtra("SIDO"));
//
//                ListView2.setAdapter(adapter);
            }
        });



    }


}
