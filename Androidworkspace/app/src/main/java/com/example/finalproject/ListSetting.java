package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Listsetting {

    ArrayList<String> allpcinfo;
    private LayoutInflater inflater;
    private ArrayList<ProductBean> product;

    public Listsetting(Object amem, int category) {
        if (category == 1) {
            allpcinfo = (ArrayList<String>) amem;
        }else{
            product = (ArrayList<ProductBean>)amem;
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
    public ProductAdapter AllProduct() {
        ProductAdapter proAdapter = new ProductAdapter(product);
        return proAdapter;
    }
    public SelectProductAdapter SelectProductAdapter() {
        SelectProductAdapter SelectProductAdapter = new SelectProductAdapter(product);
        return SelectProductAdapter;
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
    public class BasketAdapter extends BaseAdapter{
        ArrayList<ProductBean> product;

        public BasketAdapter(ArrayList basdata){
            this.product = basdata;
        }

        @Override
        public int getCount() {
            return product.size();
        }

        @Override
        public Object getItem(int i) {
            return product.get(i).getPr_name();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            if(view == null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.product_basket_list, viewGroup, false);
            }
            TextView TvBasketName, TvBasketPrice, TvBasketQTY;


            TvBasketName = view.findViewById(R.id.TvBasketName);
            TvBasketPrice = view.findViewById(R.id.TvBasketPrice);
            TvBasketQTY = view.findViewById(R.id.TvBasketQTY);


            ProductBean pro = product.get(i);

            TvBasketName.setText(pro.getPr_name());
            TvBasketPrice.setText(pro.getPr_price());
            TvBasketQTY.setText(pro.getPr_qty());

            return view;
        }
    }
    public class ProductAdapter extends BaseAdapter {
        ArrayList<ProductBean> product;

        public ProductAdapter(ArrayList prodata) {
            this.product = prodata;
        }

        @Override
        public int getCount() {
            return product.size();
        }

        @Override
        public Object getItem(int i) {
            return product.get(i).getPr_name();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            final Context context = viewGroup.getContext();
            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.product_list, viewGroup, false);

            }
            ImageView ProductImg;
            TextView ProductName, ProductPrice;



            ProductImg = v.findViewById(R.id.ProductImg);
            ProductName = v.findViewById(R.id.ProductName);
            ProductPrice = v.findViewById(R.id.ProductPrice);

            ProductBean probean = product.get(i);

            ProductName.setText(probean.getPr_name());
            ProductPrice.setText(probean.getPr_price());
            ProductImg.setImageBitmap(probean.getBimg());
            return v;

        }
    }
    public class SelectProductAdapter extends BaseAdapter {
        ArrayList<ProductBean> product;

        public SelectProductAdapter(ArrayList prodata) {
            this.product = prodata;
        }

        @Override
        public int getCount() {
            return product.size();
        }

        @Override
        public Object getItem(int i) {
            return product.get(i).getPr_name();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            final Context context = viewGroup.getContext();
            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.product_basket_list, viewGroup, false);

            }
            TextView TvBasketName, TvBasketPrice,TvBasketQTY;



            TvBasketName = v.findViewById(R.id.TvBasketName);
            TvBasketPrice = v.findViewById(R.id.TvBasketPrice);
            TvBasketQTY = v.findViewById(R.id.TvBasketQTY);

            ProductBean probean = product.get(i);

            TvBasketName.setText(probean.getPr_name());
            TvBasketPrice.setText(probean.getPr_price());
            TvBasketQTY.setText(probean.getPr_qty()+"");

            return v;

        }
    }
}
