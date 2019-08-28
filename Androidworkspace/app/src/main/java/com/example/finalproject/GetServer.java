package com.example.finalproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GetServer {
    AndroidController andcon = AndroidController.getInstance();
    Retrofit retrofit;
    String Local = "http://192.168.0.172/";
    String localURL;
    public Bitmap pictures[];
    PictureBean pictureBean;
    JSPServer Sever;
    String state;
    boolean overLap;
    MemberBean memberBean;
    MyPcBean mypcBean;
    Activity activity;
    ArrayList<String> sido;
    ArrayList<uselogBean> uselogBeans;

    //////////////////////////////////
    Map map1  = new HashMap();
    String id1;
    ArrayList<SeatBean> SeatList;
    boolean f;
    String check;
    MemberBean mba;
    ArrayList<PayMentDetail> paylist;
    ArrayList<String> arr;
    String a;


    public Bitmap[] GetServerPicture(final Activity act) {
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
            Thread.sleep(5000);
        } catch (Exception e) {

        }

        return pictures;
    }

    public boolean MemberIdOverLap(String State, Activity activity) {

        localURL = State;
        final String id = ((SignUp) activity).edtId.getText().toString();

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.Memberidoverlap(localURL, id).execute().body();
                    if (state.equals("0")) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overLap;
    }

    public boolean EazyMemberIdOverLap(String State, Activity activity) {

        localURL = State;
        final String id = ((EasySignUp) activity).edtId.getText().toString();

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.Memberidoverlap(localURL, id).execute().body();
                    if (state.equals("0")) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overLap;
    }

    public boolean GetMemberSignUp(final String State, Activity activity) {
        localURL = State;
        memberBean = andcon.member;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.InsertMember(localURL, memberBean).execute().body();
                    if (state.equals("1")) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overLap;
    }

    public boolean EazyLogin(final long kakaoID, String State, Activity act) {
        localURL = State;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    andcon.member = Sever.EazyLogin(localURL, kakaoID).execute().body();
                    if (andcon.member.getM_id() != null) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overLap;
    }

    public boolean MemberLogin(String State, Activity act) {
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
                    andcon.member = Sever.MemberLogin(localURL, id, pw).execute().body();
                    if (andcon.member.getM_id() != null) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overLap;
    }

    public boolean MemberGetId(String State, Activity act, String hp) {
        localURL = State;
        final String Hp = hp;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    andcon.member.setM_id(Sever.MemberGetId(localURL, Hp).execute().body());
                    if (andcon.member.getM_id() != null) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overLap;
    }

    public boolean UpdatePass(String State, Activity act, String id, String pw) {
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
                    state = Sever.UpdatePass(localURL, ids, pass).execute().body();
                    if (state.equals("1")) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overLap;
    }

    public boolean GetMyInfo(String State, Activity act, String hp) {
        localURL = State;

        final String Hp = hp;

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.GetMyInfo(localURL, Hp).execute().body();
                    if (state.equals("1")) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overLap;
    }

    public Bitmap[] GetPictures(PictureBean bean) {
        Bitmap[] bt = new Bitmap[3];
        try {
            if (bean.getPicture1() != null) {
                URL url = new URL("http://192.168.0.172/final_project/resources/file/" + bean.getPicture1());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                InputStream is = conn.getInputStream();
                bt[0] = BitmapFactory.decodeStream(is);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bean.getPicture2() != null) {
                URL url = new URL("http://192.168.0.172/final_project/resources/file/" + bean.getPicture2());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                InputStream is = conn.getInputStream();
                bt[1] = BitmapFactory.decodeStream(is);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bean.getPicture3() != null) {
                URL url = new URL("http://192.168.0.172/final_project/resources/file/" + bean.getPicture3());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                InputStream is = conn.getInputStream();
                bt[2] = BitmapFactory.decodeStream(is);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bt;
    }

    public boolean MyPcGetName(String State, Activity act, String name) {
        localURL = State;
        final String Name = name;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    ArrayList<MyPcBean> Mypcs = Sever.MyPcGet(localURL, Name).execute().body();
                    andcon.Mypcs = Mypcs;
                    if (andcon.Mypcs != null) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overLap;
    }

    public String bookmarkup(String State, Activity act) {
        localURL = State;
        activity = act;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.bookmarkup(localURL, andcon.UpdateMypcs).execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }

    public String Seatsearch(String State, Activity act) {
        localURL = State;
        activity = act;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.Seatsearch(localURL, andcon.UpdateMypcs.getP_id()).execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }

    public boolean pcjonDelete(String State, Activity act) {
        localURL = State;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        new Thread() {
            public void run() {
                try {
                    state = Sever.pcjonDelete(localURL, andcon.UpdateMypcs.getP_id(), andcon.UpdateMypcs.getSP_m_id()).execute().body();
                    if (state.equals("1")) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
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
                    ArrayList<PcRoomBean> pcRoomBean= Sever.getPcinfo(localURL).execute().body();
                    andcon.allpcroom = pcRoomBean;
                    if(pcRoomBean != null){
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
    public ArrayList<String> Getsido(String State, Activity act){
        localURL = State;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    sido = Sever.Getsido(localURL).execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        return sido;
    }

    public ArrayList<String> DongListSet(String State, Activity act, String Sido){
        localURL = State;
        final String ssido = Sido;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    sido = Sever.DongListSet(localURL,ssido).execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(300);
        }catch (Exception e){

        }
        return sido;
    }
    public boolean dongPcList(String State,Activity act,String dong){
        localURL = State;
        final String ddong = dong;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    andcon.Mypcs = Sever.dongPcList(localURL,ddong).execute().body();
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
            Thread.sleep(300);
        }catch (Exception e){

        }
        return overLap;

    }


    public boolean pcjoinbtn(String pcjoinbtn, Activity activity) {
        map1.put("m_id",andcon.member.getM_id());
        map1.put("p_id",andcon.UpdateMypcs.getP_id());
        localURL = "PCSignUp";
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    MyPcBean myPcBean = Sever.pcjoinbtn(localURL,map1).execute().body();
                    andcon.UpdateMypcs = myPcBean;
                    if(myPcBean !=null){
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







    public ArrayList<SeatBean> GetSeatList(final Activity act) {
        localURL = "GetSeatList";
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);


        id1 = andcon.UpdateMypcs.getP_id();

        new Thread() {
            public void run() {
                try {
                    SeatList = Sever.GetSeat(localURL, id1).execute().body();// db 컨트롤러 가는 부분
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }

        return SeatList;
    }

    public boolean SetReserve(final String State, Activity activity) {
        map1 = andcon.map;
        localURL = State;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    state = Sever.SetReserve(localURL, map1).execute().body();// db 컨트롤러 가는 부분
                    if (state.equals("1")) {
                        f = true;
                    } else {
                        f = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }

        return f;
    }

    public Bitmap[] GetServerPicture2(final Activity act) {
        localURL = "GetPicture2";
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);
        id1 = andcon.UpdateMypcs.getP_id();

        new Thread() {
            public void run() {
                try {
                    pictureBean = Sever.getPictures2(localURL, id1).execute().body();// db 컨트롤러 가는 부분
                    pictures = GetPictures2(pictureBean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }

        return pictures;
    }

    public Bitmap[] GetPictures2(PictureBean bean) {
        Bitmap[] bt = new Bitmap[1];
        id1=andcon.UpdateMypcs.getP_id();
        try {

            URL url = new URL("http://192.168.0.172/final_project/resources/" + id1 + "/" + bean.getPicture1());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            bt[0] = BitmapFactory.decodeStream(is);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return bt;
    }
    public Bitmap[] GetPictures3(PictureBean bean) {
        Bitmap[] bt = new Bitmap[1];
        id1=andcon.UpdateMypcs.getP_id();
        try {

            URL url = new URL("http://192.168.0.172/final_project/resources/file/" + bean.getPicture1());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            bt[0] = BitmapFactory.decodeStream(is);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return bt;
    }


    public boolean reserveConfirm(String State, Activity activity) {
        map1 = andcon.map;
        localURL = "reserveConfirm";
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        map1.put("m_id", andcon.member.getM_id());
        map1.put("p_id", andcon.sb.getP_id());

        new Thread() {
            public void run() {
                try {
                    state = Sever.reserveConfirm(localURL, map1).execute().body();// db 컨트롤러 가는 부분
                    if (state.equals("1")) {
                        f = true;
                    } else {
                        f = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }

        return f;
    }

    public boolean reserveDelete(String reserveDelete, Activity activity) {
        map1 = andcon.map;
        localURL = "reserveDelete";
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);


        new Thread() {
            public void run() {
                try {
                    state = Sever.reserveDelete(localURL, map1).execute().body();// db 컨트롤러 가는 부분
                    if (state.equals("1")) {
                        f = true;
                    } else {
                        f = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }

        return f;

    }
    public ArrayList<uselogBean> Getuselog(String State, Activity act){
        localURL = State;
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    uselogBeans = Sever.Getuselog(localURL,andcon.UpdateMypcs.getP_id()).execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(300);
        }catch (Exception e){

        }
        return uselogBeans;
    }
    public void cateSearch(String State, Activity act){
        localURL = State;

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run(){
                try{
                    andcon.cates = Sever.cateSearch(localURL,andcon.UpdateMypcs.getP_id()).execute().body();
                    if(andcon.cates !=null);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void Getproduct(String State,Activity act){
        localURL = State;

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run(){
                try{
                    andcon.MyProduct = Sever.Getproduct(localURL).execute().body();
                    if(andcon.cates !=null);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void insertPay(String State,Activity activity){
        localURL = State;

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run(){
                try{
                    String state = Sever.insertPay(localURL,andcon.payBeans,andcon.member.getM_id()).execute().body();
                    if(andcon.cates !=null);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean CheckUsing(String State,Activity activity) {
        localURL = "CheckUsing";

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    String check = Sever.CheckUsing(localURL,andcon.member.getM_id()).execute().body();
                    if(check.equals("1")){
                        overLap = true;
                    }else{
                        overLap = false;
                    }
                    if (andcon.cates != null) ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overLap;
    }

    public String GetCountCheck(String State,Activity activity){
        localURL = "GetCountCheck";

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    state = Sever.GetCountCheck(localURL,andcon.member.getM_id()).execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }
    public String SelectReserve(String state, Activity activity) {
        localURL = state;

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    String check = Sever.CheckUsing(localURL, andcon.member.getM_id()).execute().body();
                    if (check.equals("1")) {
                        overLap = true;
                    } else {
                        overLap = false;
                    }
                    if (andcon.cates != null) ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "1";
    }

    public ArrayList<PayMentDetail> SelectPayList1(String state, Activity activity) {
        localURL = "SelectPayList1";


        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    paylist = Sever.SelectPayList1(localURL, andcon.member.getM_id()).execute().body();
                    if(paylist !=null){

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paylist;
    }




    public boolean SelectReserveChecking(String state, Activity activity) {
        localURL = "SelectReserveChecking";

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    check = null;
                    check = Sever.SelectReserveChecking(localURL, andcon.member.getM_id()).execute().body();

                    if (check != null) {
                        overLap = true;
                        andcon.check = check;
                    } else {
                        overLap = false;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return overLap;

    }

    public String SelectReserveinfo1(String state, Activity activity, final String check1) {
        localURL = "SelectReserveinfo1";

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    //, 좌석 아이디 *\(check1),피시방 이름,피시방 아이디
                    map1 = Sever.SelectReserveinfo1(localURL, check1).execute().body();

                    String b = map1.get("sid").toString().split(map1.get("pid").toString())[1];
                    a = map1.get("pname").toString() +"      "+ b+"번 좌석";

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public ArrayList<String> BookMarkList(String state, Activity activity) {

        localURL = "BookMarkList";

        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    //, 좌석 아이디 *\(check1),피시방 이름,피시방 아이디
                    arr = Sever.BookMarkList(localURL, andcon.member.getM_id()).execute().body();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }


    public boolean MyInfoUpdate(String state, Activity activity, MemberBean a) {
        localURL = "MyInfoUpdate";
        mba = a;
        mba.setM_id(andcon.member.getM_id());
        if(mba.getM_nickname().equals("")){
            mba.setM_nickname(andcon.member.getM_nickname());
        }
        if(mba.getM_email().equals("")){
            mba.setM_email(andcon.member.getM_email());
        }
        if(mba.getM_phone().equals("")){
            mba.setM_phone(andcon.member.getM_phone());
        }
        retrofit = new Retrofit.Builder().baseUrl(Local)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sever = retrofit.create(JSPServer.class);

        new Thread() {
            public void run() {
                try {
                    check = null;
                    check = Sever.MyInfoUpdate(localURL,mba).execute().body();

                    if (check.equals("1")) {
                        overLap = true;

                    } else {
                        overLap = false;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return overLap;
    }
}
