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


    public ListView ListView1, ListView2;
    TextView sido;
    private ArrayList<PcRoomBean> data = null;
    private ArrayList<PcRoomBean> data2 = null;

    AndroidController andcon = AndroidController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_room_gps);

        ListView1 = findViewById(R.id.ListView1);
        ListView2 = findViewById(R.id.ListView2);

        data = new ArrayList<>();
        data2 = new ArrayList<>();

        PcRoomBean PcRoomBean1 = new PcRoomBean("경기도");
        PcRoomBean PcRoomBean2 = new PcRoomBean("시흥시");

        data.add(PcRoomBean1);
        data2.add(PcRoomBean2);

        final PcRoomAdapter adapter = new PcRoomAdapter(this, R.layout.activity_pc_room_one_list, data);
        final PcRoomAdapter adapter2 = new PcRoomAdapter(this, R.layout.activity_pc_room_one_list, data2);
        ListView1.setAdapter(adapter);


        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), PcRoomGPS.class);

                intent.putExtra("SIDO", data.get(position).getP_SIDO());
                intent.putExtra("GUGUN", data.get(position).getP_GUGUN());
                intent.putExtra("DONG", data.get(position).getP_DONG());
                intent.putExtra("ADDR", data.get(position).getP_ADDR());


                sido = findViewById(R.id.sido);
                sido.setText(intent.getStringExtra("SIDO"));

                ListView2.setAdapter(adapter2);
            }
        });



    }


}
