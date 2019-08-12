package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyPcRoomAdapterSetting {
    private LayoutInflater inflater;
    private ArrayList<MyPcBean> data;
    private int Layout;
    ImageButton startbtn;
    TextView pcname, pclocation;
    Button delete;
    public MyPcRoomAdapterSetting(ArrayList arrayList){
        data = arrayList;
    }

    public MyPcRoomAdapter mypcSearch(){
        MyPcRoomAdapter myAdapter = new MyPcRoomAdapter(data);
        return myAdapter;
    }

    public class MyPcRoomAdapter extends BaseAdapter {
        ArrayList<MyPcBean> data;

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
        public View getView(int position, View view, ViewGroup viewGroup) {

            final Context context = viewGroup.getContext();
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_mypccontent, viewGroup, false);
            }

            TextView pcname, pclocation;

            pcname = view.findViewById(R.id.pcname);
            pclocation = view.findViewById(R.id.pclocation);
            startbtn = view.findViewById(R.id.starbtn);

            MyPcBean mypcbean = data.get(position);

            pcname.setText(mypcbean.getP_name());
            pclocation.setText(mypcbean.getP_sido() + mypcbean.getP_gugun() + mypcbean.getP_dong() + mypcbean.getP_addr());
            if (mypcbean.getST_star().equals("1")) {
                startbtn.setBackgroundResource(R.drawable.star);
            } else {
                startbtn.setBackgroundResource(R.drawable.clickstar);
            }
            return view;
        }
    }
}
