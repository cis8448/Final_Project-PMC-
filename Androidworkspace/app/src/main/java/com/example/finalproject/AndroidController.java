package com.example.finalproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

public class AndroidController {
    ArrayList<MemberBean> allmem;

    Activity MainAct;
    Activity SubAct;
    GetServer Server = new GetServer();

    static AndroidController androidcontroller;

    private AndroidController(){

    }
    public static AndroidController getInstance() {
        if (androidcontroller == null){
            androidcontroller = new AndroidController();
        }
        return androidcontroller;
    }

    public void setActivity(Activity act) {
        MainAct = act;
    }//액티비티저장
    public void setActivity2(Activity act) {
        SubAct = act;
    }
    public static void cutComtroll(){
        androidcontroller = null;
    }
    public void sub(Activity activity, String state){
      //사진 가져오기
        if(state.equals("GetPicture")){
            ((MainActivity)activity).pictures = Server.GetServerPicture(activity);
        }
        if(state.equals("SettingPictuer")){
            ((MainActivity)activity).pictures = Server.pictures;
        }

    }
}
