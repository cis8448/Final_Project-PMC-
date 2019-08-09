package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




    }

    public void FindIdPassOpen(View view) {
        andcon.sub(this,"FindIdPassOpen");
    }

    public void SignUpSelect(View view) {
        andcon.sub(this,"SignUpSelectOpen");
    }


}

