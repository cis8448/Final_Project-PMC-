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

public class MyPcRoomAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<MyPcBean> data;
    private int Layout;
    ImageButton offstartbtn, onstartbtn;
    TextView pcname, pclocation;
    Button delete;

    public MyPcRoomAdapter(Context context, int Layout, ArrayList<MyPcBean> data){
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.Layout = Layout;
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

        if (view == null) {
            view = inflater.inflate(Layout, viewGroup, false);
        }
        MyPcBean mypcbean = data.get(position);

        pcname = view.findViewById(R.id.pcname);


        pcname.setText(mypcbean.getP_name());


        return view;
    }
}
