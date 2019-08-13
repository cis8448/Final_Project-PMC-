package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WhenPcroom extends AppCompatActivity {
    public MyPcRoomAdapter adapter;
    private ArrayList<MyPcBean> data = null;
    public ListView mypclist;
    MyPcBean mpb;
    TextView pclocation,pcname;
    int itemposition;
    ImageButton btn1;
    DrawerLayout DL;

    AndroidController andcon = AndroidController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_pcroom);

        pclocation = findViewById(R.id.pclocation);
        pcname =findViewById(R.id.pcname);
        mypclist = findViewById(R.id.mypclist);
        DL = findViewById(R.id.drawlay);
        btn1 =findViewById(R.id.btn1);
        andcon.setActivity(this);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DL.openDrawer(Gravity.LEFT);
            }
        });



        if(adapter == null){
            adapter = new MyPcRoomAdapter(andcon.Mypcs);
        }
        mypclist.setAdapter(adapter);
        data = new ArrayList<>();

        mypclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
    //세팅 버튼
    public void btnSetting(View view){
        andcon.sub(this,"btnSetting");
    }

    //홈으로 가기 버튼 처리
    public void btnHome(View view){
        andcon.sub(this,"btnHome");
    }

    //전체 공지사항 버튼
    public void Notice(View view){
        andcon.sub(this,"Notice");
    }


    //내 정보 버튼 처리
    public void btnMyInfo(View view){
        andcon.sub(this,"btnMyInfo");
    }

    //퀵 메뉴 설정
    public void btnQuick(View view){
        andcon.sub(this,"btnQuick");
    }

    //가입한 피시방
    public void btnMyPc(View view){
        andcon.sub(this,"btnMyPc");
    }



    //좌석현황
    public void SeatState(View view){
        andcon.sub(this,"SeatState");
    }
    //상품주문
    public void ProductOrder(View view){
        andcon.sub(this,"ProductOrder");
    }

    //pc방 찾기
    public void PcSearch(View view){
        andcon.sub(this,"PcSearch");
    }

    //1:1문의
    public void Inquiry(View view){
        andcon.sub(this,"Inquiry");
    }

}



class MyPcRoomAdapter extends BaseAdapter {
    AndroidController andcon = AndroidController.getInstance();
    ArrayList<MyPcBean> data;
    Button startbtn;
    public MyPcRoomAdapter(ArrayList mydata) {
        this.data = mydata;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getP_name();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {

        final TextView pcname, pclocation;
        Button delete;
        LinearLayout mypcname;

        final Context context = viewGroup.getContext();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_mypccontent, viewGroup,false
                    );
        }

        mypcname = view.findViewById(R.id.mypcname);
        pcname = view.findViewById(R.id.pcname);
        pclocation = view.findViewById(R.id.pclocation);
        startbtn = view.findViewById(R.id.starbtn);
        delete = view.findViewById(R.id.delete);
        final MyPcBean mypcbean = data.get(position);

        pcname.setText(mypcbean.getP_name());
        pclocation.setText(mypcbean.getP_sido() + mypcbean.getP_gugun() + mypcbean.getP_dong() + mypcbean.getP_addr());
        if (mypcbean.getST_star().equals("1")) {
            startbtn.setBackgroundResource(R.drawable.clickstar);
        } else {
            startbtn.setBackgroundResource(R.drawable.star);
        }
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.get(position).getST_star().equals("1")){
                    data.get(position).setST_star("0");
                    andcon.Mypcs.get(position).setST_star("0");
                    andcon.UpdateMypcs = andcon.Mypcs.get(position);
                    startbtn.setBackgroundResource(R.drawable.clickstar);
                    andcon.sub(((WhenPcroom)context),"bookmarkUp");
                    ((WhenPcroom)context).adapter.notifyDataSetChanged();

                }else{
                    data.get(position).setST_star("1");
                    andcon.Mypcs.get(position).setST_star("1");
                    andcon.UpdateMypcs = andcon.Mypcs.get(position);
                    startbtn.setBackgroundResource(R.drawable.star);
                    andcon.sub(((WhenPcroom)context),"bookmarkUp");
                    ((WhenPcroom)context).adapter.notifyDataSetChanged();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                andcon.UpdateMypcs = andcon.Mypcs.get(position);
                andcon.sub(((WhenPcroom)context),"pcjoinDelete");
                if(andcon.Check) {
                    andcon.Mypcs.remove(position);
                    ((WhenPcroom) context).adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(context, " 탈퇴에 실패했습니다 다시 시도해 주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mypcname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            andcon.UpdateMypcs = andcon.Mypcs.get(position);
            andcon.sub((WhenPcroom)context,"PcDetileOpen");


            }
        });

        return view;



    }






}


