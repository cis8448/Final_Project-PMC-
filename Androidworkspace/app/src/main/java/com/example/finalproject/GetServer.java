package com.example.finalproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GetServer {
    Retrofit retrofit;
    String Local = "http://192.168.0.172/";
    String localURL ;
    public Bitmap pictures[];
    PictureBean pictureBean;
    JSPServer Sever;
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
            Thread.sleep(500);
        }catch (Exception e){

        }

        return pictures;
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
}
