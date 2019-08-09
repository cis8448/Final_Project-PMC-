package com.example.finalproject;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.kakao.auth.ApiResponseCallback;
import com.kakao.auth.AuthService;
import com.kakao.auth.network.response.AccessTokenInfoResponse;
import com.kakao.kakaotalk.callback.TalkResponseCallback;
import com.kakao.kakaotalk.v2.KakaoTalkService;
import com.kakao.message.template.LinkObject;
import com.kakao.message.template.TextTemplate;
import com.kakao.network.ErrorResult;


public class KakaoMessege {

    public void KakaosendMessege(Activity act) {
        LinkObject link = LinkObject.newBuilder().setWebUrl("https://developer.kakao.com").setMobileWebUrl("https://qr.kakao.com/talk/Xpg9sse5dZBL3eElyJfDc7zrwi8-").build();
        TextTemplate params = TextTemplate.newBuilder("Test", link).build();
        AuthService.getInstance().requestAccessTokenInfo(new ApiResponseCallback<AccessTokenInfoResponse>() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                Log.e("asdasd", "onSessionClosed: " );
            }

            @Override
            public void onNotSignedUp() {

            }

            @Override
            public void onSuccess(AccessTokenInfoResponse result) {
                    long userId = result.getUserId();
                Log.d("dddddd", "onSuccess: "+userId);
            }
        });

        KakaoTalkService.getInstance().requestSendMemo(new TalkResponseCallback<Boolean>() {
            @Override
            public void onNotKakaoTalkUser() {
                Log.e("cccc", "onSuccess!: " );
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                Log.e("cccc", "onSuccess123: " );
            }

            @Override
            public void onNotSignedUp() {
                Log.e("cccc", "onSuccess1234: " );
            }

            @Override
            public void onSuccess(Boolean result) {
                Log.e("ccc", "onSuccess1235: " );
            }
        }, params);
    }
}