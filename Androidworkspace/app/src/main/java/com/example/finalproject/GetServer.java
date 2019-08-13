package com.example.finalproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GetServer {
    AndroidController andcon = AndroidController.getInstance();
    Retrofit retrofit;
    String Local = "http://192.168.0.166/";
    String localURL ;
    public Bitmap pictures[];
    PictureBean pictureBean;
    JSPServer Sever;
    String state;
    boolean overLap;
    MemberBean memberBean;
    MyPcBean mypcBean;
    public Bitmap[] GetServerPicture(final Activity act){
        localURL = "GetPicture";
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    pictureBean = Sever.getPictures(localURL).execute().body();
                    pictures = GetPictures(pictureBean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }

        return pictures;
    }

    public boolean MemberIdOverLap(String State, Activity activity){

        localURL = State;
        final String id = ((SignUp)activity).edtId.getText().toString();

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.Memberidoverlap(localURL,id).execute().body();
                    if(state.equals("0")){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return overLap;
    }
    public boolean EazyMemberIdOverLap(String State, Activity activity){

        localURL = State;
        final String id = ((EasySignUp)activity).edtId.getText().toString();

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.Memberidoverlap(localURL,id).execute().body();
                    if(state.equals("0")){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return overLap;
    }
    public boolean GetMemberSignUp(final String State, Activity activity){
        localURL = State;
        memberBean = andcon.member;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.InsertMember(localURL,memberBean).execute().body();
                    if(state.equals("1")){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return overLap;
    }
    public boolean EazyLogin(final long kakaoID, String State, Activity act){
        localURL = State;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    andcon.member = Sever.EazyLogin(localURL,kakaoID).execute().body();
                    if(andcon.member.getM_id() != null){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        return overLap;
    }
    public boolean MemberLogin(String State, Activity act){
        localURL = State;
        final String id = andcon.member.getM_id();
        final String pw = andcon.member.getM_pass();
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    andcon.member = Sever.MemberLogin(localURL,id,pw).execute().body();
                    if(andcon.member.getM_id() != null){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        return overLap;
    }
    public boolean MemberGetId(String State, Activity act,String hp){
        localURL = State;
        final String Hp = hp;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    andcon.member.setM_id(Sever.MemberGetId(localURL,Hp).execute().body());
                    if(andcon.member.getM_id() != null){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return overLap;
    }
    public boolean UpdatePass(String State, Activity act,String id,String pw){
        localURL = State;

        final String ids = id;
        final String pass = pw;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.UpdatePass(localURL,ids,pass).execute().body();
                    if(state.equals("1")){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        return overLap;
    }
    public boolean GetMyInfo(String State,Activity act,String hp){
        localURL = State;

        final String Hp = hp;

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.GetMyInfo(localURL,Hp).execute().body();
                    if(state.equals("1")){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        return overLap;
    }
    public Bitmap[] GetPictures(PictureBean bean){
        Bitmap[] bt = new Bitmap[3];
        try {
            if (bean.getPicture1() != null) {
                URL url = new URL("http://192.168.0.172/final_project/resources/file/"+bean.getPicture1());
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                InputStream is =conn.getInputStream();
                bt[0] = BitmapFactory.decodeStream(is);
            }else if(bean.getPicture2() != null){
                URL url = new URL("http://192.168.0.172/final_project/resources/file/"+bean.getPicture2());
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                InputStream is =conn.getInputStream();
                bt[1] = BitmapFactory.decodeStream(is);
            }else if(bean.getPicture3()!=null){
                URL url = new URL("http://192.168.0.172/final_project/resources/file/"+bean.getPicture3());
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                InputStream is =conn.getInputStream();
                bt[2] = BitmapFactory.decodeStream(is);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return bt;
    }

    public boolean MyPcGetName(String State, Activity act,String name){
        localURL = State;
        final String Name = name;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    ArrayList<MyPcBean> Mypcs = Sever.MyPcGet(localURL,Name).execute().body();
                    andcon.Mypcs = Mypcs;
                    if(andcon.Mypcs != null){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return overLap;
    }


    public boolean GetServerPcinfo(String State, Activity act) {
        localURL = State;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    PcRoomBean pcRoomBean= Sever.getPcinfo(localURL).execute().body();
                    andcon.pcRoomBean = pcRoomBean;
                    if(state.equals("1")){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }

        return overLap;

    }
}
