package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PcRoominfoAdapter extends BaseAdapter {
    private ArrayList<MyPcBean> data;
    TextView MyPcName;
    private int Layout;
    private LayoutInflater inflater;

    public PcRoominfoAdapter(Context context, int Layout, ArrayList<MyPcBean> data){
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.Layout = Layout;
    }

    @Override
    public int getCount(){
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
        MyPcBean myPcBean= data.get(position);

        MyPcName = view.findViewById(R.id.MyPcName);

        MyPcName.setText(myPcBean.getP_name());


        return view;
    }
}
