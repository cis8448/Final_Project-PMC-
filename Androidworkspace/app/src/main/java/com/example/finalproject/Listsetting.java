package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Listsetting {

    ArrayList<PcRoomBean> allpcinfo;

    public Listsetting(Object amem, int category) {
        if (category == 1) {
            allpcinfo = (ArrayList<PcRoomBean>) amem;
        }

    }
    public PcRoomAdapter memberListSetting(){
        PcRoomAdapter memberAdapter = new PcRoomAdapter(allpcinfo);
        return memberAdapter;
    }

    public class PcRoomAdapter extends BaseAdapter {
        ArrayList<PcRoomBean> allpcinfo;

        TextView sido;


        public PcRoomAdapter(ArrayList allpc) {
            this.allpcinfo = allpc;
        }

        @Override
        public int getCount() { //리스트 안에 갯수
            return allpcinfo.size();
        }

        @Override
        public Object getItem(int position) {
            return allpcinfo.get(position).getP_sido();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final int pos = position;
            final Context context = parent.getContext();
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_pc_room_one_list,parent,false);
            }

            sido = convertView.findViewById(R.id.sido);

            PcRoomBean mem = allpcinfo.get(position);

            sido.setText(mem.getP_sido());
            return convertView;
        }
    }
}
