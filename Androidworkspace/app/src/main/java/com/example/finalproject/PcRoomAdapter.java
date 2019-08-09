package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PcRoomAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<PcRoomBean> data;
    private int Layout;
    TextView sido;

    public PcRoomAdapter(Context context, int Layout, ArrayList<PcRoomBean> data){
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.Layout = Layout;
    }

    @Override
    public int getCount() { //리스트 안에 갯수
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getP_SIDO();
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
        PcRoomBean pcRoomBean = data.get(position);

        sido = view.findViewById(R.id.sido);

        sido.setText(pcRoomBean.getP_SIDO());

        return view;
    }
}
