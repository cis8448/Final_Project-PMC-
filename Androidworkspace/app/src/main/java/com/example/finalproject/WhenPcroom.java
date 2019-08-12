package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WhenPcroom extends AppCompatActivity {
    public MyPcRoomAdapterSetting.MyPcRoomAdapter adapter;
    private ArrayList<MyPcBean> data = null;
    ListView mypclist;
    MyPcBean mpb;
    TextView pclocation,pcname;

    AndroidController andcon = AndroidController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_pcroom);

        pclocation = findViewById(R.id.pclocation);
        pcname =findViewById(R.id.pcname);
        mypclist = findViewById(R.id.mypclist);
        if(adapter == null){
            andcon.sub(this,"getMypcAdapter");
        }
        mypclist.setAdapter(adapter);
        data = new ArrayList<>();

        mypclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                andcon.sub(WhenPcroom.this,"pcdetail");
            }
        });

    }



}
