package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class WhenPcroom extends AppCompatActivity {
    ArrayList<String> pData= new ArrayList<String>();

    ListView mypclist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_pcroom);

        

        mypclist = findViewById(R.id.mypclist);
       final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.mypcroombtn);
        mypclist.setAdapter(adapter);





    }
}
