package com.example.finalproject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.finalproject.Bean.ProductBean;

import java.util.ArrayList;

public class ListSetting {

    ArrayList<ProductBean> allproduct;

    int[] img; //이미지

    public class ProductAdapterSet extends BaseAdapter{
        ArrayList<ProductBean> allproduct;
        public ProductAdapterSet(ArrayList allpro){
            this.allproduct = allpro;
        }

        @Override
        public int getCount() {
            return allproduct.size();
        }

        @Override
        public Object getItem(int i) {
            return allproduct.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ProductBean productbean;
            int productPos = i;


            return null;
        }
    }
}