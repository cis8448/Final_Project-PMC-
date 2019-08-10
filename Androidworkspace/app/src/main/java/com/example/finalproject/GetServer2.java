package com.example.finalproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetServer2 {
    Retrofit retrofit;
    String Local = "http://192.168.0.174/";
    String localURL ;
    public Bitmap pictures[];
    PictureBean pictureBean;
    JSPServer Sever;
    String id1;
    public Bitmap[] GetServerPicture(final Activity act,String id){
        localURL = "GetPicture2";
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        id1 = id;

        new Thread() {
            public void run() {
                try {
                    pictureBean = Sever.getPictures2(localURL,id1).execute().body();// db 컨트롤러 가는 부분
                    pictures = GetPictures(pictureBean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        }catch (Exception e){

        }

        return pictures;
    }
    public Bitmap[] GetPictures(PictureBean bean){
        Bitmap[] bt = new Bitmap[1];
        try {
            if (bean.getPicture1() != null) {
                URL url = new URL("http://192.168.0.174/final_project/resources/"+id1+"/"+bean.getPicture1());
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                InputStream is =conn.getInputStream();
                bt[0] = BitmapFactory.decodeStream(is);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return bt;
    }
}
