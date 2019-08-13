package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class myIdChecks extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();
    TextView idtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_id_check);
        idtxt = findViewById(R.id.idtxt);
        idtxt.setText(andcon.member.getM_id());
    }

    public void idcheckfinish(View v){
        finish();
    }

    public void PassUpdateOpen(View v){
        andcon.sub(this,"PassUpdateOpen");
    }
}
