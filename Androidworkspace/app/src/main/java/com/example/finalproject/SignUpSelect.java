package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.User;

import java.util.ArrayList;
import java.util.List;

public class SignUpSelect extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();
    LoginButton kakabtn;
    MemberBean memberBean = new MemberBean();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_select);
        kakabtn = findViewById(R.id.com_kakao_login);
    }
    public void SignUp(View v){
        andcon.sub(this,"SignUpOpen");
    }

    public void KakaoSignUp(View v){
        List<String> keys = new ArrayList<>();
        keys.add("properties.nickname");
        keys.add("kakao_account.birthday");
        keys.add("kakao_account.email");
        keys.add("properties.profile_image");
        keys.add("kakao_account.age_range");
        UserManagement.getInstance().me(keys, new MeV2ResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                kakabtn.performClick();
            }

            @Override
            public void onSuccess(MeV2Response result) {
                memberBean.setM_kakaoid(result.getId());
                memberBean.setM_profile(result.getProfileImagePath());
                memberBean.setM_birthday(result.getKakaoAccount().getAgeRange().toString());
                memberBean.setM_email(result.getKakaoAccount().getEmail());
                andcon.member = memberBean;
                andcon.sub(SignUpSelect.this, "EasySignUpOpen");
            }
        });


    }
}
