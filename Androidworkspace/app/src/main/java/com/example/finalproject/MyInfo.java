package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyInfo extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();

    TextView TvUserName, TvUserRese;
    Button mbtn1, mbtn2, mbtn3, ubtn1;
    String reserverinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        TvUserName = findViewById(R.id.TvUserName);
        TvUserRese = findViewById(R.id.TvUserRese);
        mbtn1 = findViewById(R.id.mbtn1);
       // mbtn2 = findViewById(R.id.mbtn2);
        mbtn3 = findViewById(R.id.mbtn3);
        ubtn1 = findViewById(R.id.ubtn1);

        // andcon.sub(MyInfo.this,"SelectReserve");
//        andcon.sub(this, "SelectReserveChecking");
        TvUserName.setText(andcon.member.getM_id());
        TvUserRese.setText(andcon.member.getM_name());

        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                andcon.sub(MyInfo.this, "SelectReserveChecking");
                Toast.makeText(MyInfo.this, reserverinfo, Toast.LENGTH_SHORT).show();
            }
        });


//        mbtn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                andcon.sub(MyInfo.this, "BookMarkOpen");
//            }
//        });


        mbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                andcon.sub(MyInfo.this, "PayListOpen");
            }
        });

        ubtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                andcon.sub(MyInfo.this,"myinfoupdateopen");
            }
        });
    }
}
