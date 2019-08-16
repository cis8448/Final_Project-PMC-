package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Listsetting {

    ArrayList<String> allpcinfo;

    public Listsetting(Object amem, int category) {
        if (category == 1) {
            allpcinfo = (ArrayList<String>) amem;
        }

    }
    public PcRoomAdapter memberListSetting(){
        PcRoomAdapter memberAdapter = new PcRoomAdapter(allpcinfo);
        return memberAdapter;
    }
    public PcRoomAdapter pcRoomListSetting(){
        PcRoomAdapter pcroomAdapter = new PcRoomAdapter(allpcinfo);
        return pcroomAdapter;
    }

    public class PcRoomAdapter extends BaseAdapter {
        ArrayList<String> allpcinfo;

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
            return allpcinfo.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final Context context = parent.getContext();
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_pc_room_one_list,parent,false);
            }

            sido = convertView.findViewById(R.id.sido);
            String text = allpcinfo.get(position);
            sido.setText(text);
            return convertView;
        }
    }
}
