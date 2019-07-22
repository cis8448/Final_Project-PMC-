package com.example.finalproject;

import android.app.Application;

import com.kakao.auth.KakaoSDK;

public class GlobalSDK extends Application {
    private static GlobalSDK instance;
    public static GlobalSDK getGlobalApplicationContext() {
        if (instance == null) {
            throw new IllegalStateException("This Application does not inherit com.kakao.GlobalApplication");
        }
        return instance;
    }
    public void onCreate() {
        super.onCreate();
        instance = this;
        KakaoSDKAdapter sdk = new KakaoSDKAdapter();
        KakaoSDK.init(sdk);
    }
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}
