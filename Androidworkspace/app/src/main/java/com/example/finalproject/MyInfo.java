package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MyInfo extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();

    TextView TvUserName, TvUserRese;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        TvUserName = findViewById(R.id.TvUserName);
        TvUserRese = findViewById(R.id.TvUserRese);

        andcon.sub(this,"SelectReserve");
        TvUserName.setText(andcon.member.getM_id());
        TvUserRese.setText(andcon.member.getM_name());



    }
}
