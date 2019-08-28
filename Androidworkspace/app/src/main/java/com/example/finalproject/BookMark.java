package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
public class BookMark extends AppCompatActivity {

    AndroidController andcon = AndroidController.getInstance();
    ListView blist;
    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_mark);

        blist = findViewById(R.id.blist);

        andcon.sub(this, "BookMarkList");

        if(list == null){
            list = new ArrayList<>();
            list.add("결제내역이 없습니다");
        }

        final ArrayAdapter<String> BookMarkAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        blist.setAdapter(BookMarkAdapter);
    }
}
