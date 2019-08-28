package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class PayList extends AppCompatActivity {

    Button pbtn1;
    ListView plist1;
    TextView ptx1, ptx2, ptx3, ptx4;
    AndroidController andcon = AndroidController.getInstance();
    ArrayList<PayMentDetail> paylist;
    paylistadapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_list);

        pbtn1 = findViewById(R.id.pbtn1);

        plist1 = findViewById(R.id.plist1);

        andcon.sub(PayList.this, "SelectPayList1");
        if(paylist != null){
            adapter = new paylistadapter(paylist);
        }

        if (paylist == null) {
            PayMentDetail a = new PayMentDetail();
            a.setPr_name("결제내역이 없습니다~");
            paylist = new ArrayList<>();
            paylist.add(a);
            adapter = new paylistadapter(paylist);
        }


        pbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                andcon.sub(PayList.this, "SelectPayList1");
            }
        });


        if (paylist == null) {
            andcon.sub(PayList.this, "SelectPayList1");
        }
        plist1.setAdapter(adapter);

    }

    public class paylistadapter extends BaseAdapter {
        ArrayList<PayMentDetail> paylists;

        paylistadapter(ArrayList<PayMentDetail> list) {
            paylists = list;
        }

        @Override
        public int getCount() {
            return paylists.size();
        }

        @Override
        public Object getItem(int i) {
            return paylists.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            Context context = viewGroup.getContext();
            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.activity_paylist, viewGroup, false);
            }
            ptx1 = v.findViewById(R.id.ptx1);
            ptx2 = v.findViewById(R.id.ptx2);
            ptx3 = v.findViewById(R.id.ptx3);
            ptx4 = v.findViewById(R.id.ptx4);

            String str1[] = new String[2];
            str1=paylists.get(i).getU_start().split(" ");
            ptx1.setText(str1[0]);
            ptx2.setText(paylists.get(i).getPc_p_id());
            ptx3.setText(paylists.get(i).getPr_name());
            //ptx4.setText(paylists.get(i).getPl_price());


            return v;
        }
    }
}