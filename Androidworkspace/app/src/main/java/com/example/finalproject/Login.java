package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();

    LoginButton kakaoBtn;
    EditText edtId,edtpw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        kakaoBtn = findViewById(R.id.kakaiLogin);
        edtId = findViewById(R.id.edtId);
        edtpw = findViewById(R.id.edtpw);
    }

    public void SignUpSelect(View v){
        andcon.sub(this,"signUpSelectOpen");
    }

    public void LoginStart(View v){
        String id = edtId.getText().toString();
        String pw = edtpw.getText().toString();
        if(id.equals("")&&pw.equals("")){
            Toast.makeText(this, "아이디와 비밀번호 모두 입력해주세요", Toast.LENGTH_SHORT).show();
        }else{
            andcon.member.setM_id(id);
            andcon.member.setM_pass(pw);
            andcon.sub(this,"MemberLogin");
        }
    }

    public  void FindIdPassOpen(View v){
        andcon.sub(this,"certificationOpen");
    }

    public void EasyLogin(View v){
        List<String> keys = new ArrayList<>();
        keys.add("properties.nickname");
        UserManagement.getInstance().me(keys, new MeV2ResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                kakaoBtn.performClick();
                Toast.makeText(Login.this, "카카오 로그인 후 다시 시도해 주세요", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(MeV2Response result) {
                andcon.member.setM_kakaoid(result.getId());
                andcon.sub(Login.this,"EazyLosin");
            }
        });
    }
}
