package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpSelect extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_select);
    }

    public void SignUp(View view) {
        andcon.sub(this,"SignUpOpen");
    }
}
