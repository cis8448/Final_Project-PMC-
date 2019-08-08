package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void SignUpSelect(View view) {
        andcon.sub(this,"SignUpSelectOpen");
    }


    public void idcheck(View view){
        andcon.sub(this, "idcheck");
    }

    public void passcheck(View view){
        andcon.sub(this, "passcheck");
    }
}
