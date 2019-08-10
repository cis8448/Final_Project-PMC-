package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WhenPcroom extends AppCompatActivity {

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

        data = new ArrayList<>();

        String pname =  mpb.getP_name();
        String plocation = mpb.getP_sido()+mpb.getP_gugun()+mpb.getP_dong()+mpb.getP_addr();


        pcname.setText(pname);
        pclocation.setText(plocation);



        final MyPcRoomAdapter adapter = new MyPcRoomAdapter(this, R.layout.activity_mypccontent, data);
        mypclist.setAdapter(adapter);




    }
}
