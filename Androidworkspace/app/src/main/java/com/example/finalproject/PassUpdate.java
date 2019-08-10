package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PassUpdate extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();
    EditText edtpw1,edtpw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_update);
        edtpw1 = findViewById(R.id.edtpw1);
        edtpw2 = findViewById(R.id.edtpw2);
    }
    public void UpdatePass(View v){
        String edt1 = edtpw1.getText().toString();
        String edt2 = edtpw2.getText().toString();
        if(!edt1.equals("")){
            if(edt1.equals(edt2)){
                andcon.member.setM_pass(edt1);
                andcon.sub(this,"UpdatePass");
            }else{
                Toast.makeText(this, "비밀번호가 맞지 않습니다 비밀번호를 확인해 주세요", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
        }
    }
}
