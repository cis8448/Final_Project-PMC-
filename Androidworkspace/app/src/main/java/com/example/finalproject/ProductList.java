package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;

import com.example.finalproject.Bean.ProductBean;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductList extends AppCompatActivity {

    AndroidController andcon = AndroidController.getInstance();
    HorizontalScrollView HsvCate;
    GridView GridProduct;
    ArrayList<HashMap<String, String>> list = new ArrayList<>();
    ArrayList<ProductBean> prob;

    SimpleAdapter simple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        HsvCate = findViewById(R.id.HsvCate); //카테고리 리스트뷰
        GridProduct = findViewById(R.id.GridProduct); // 상품 이미지 리스트뷰

        prob = new ArrayList<>();

        ProductBean Cate = new ProductBean("0",0,0,0,0)


    }

    public void ProductBasket(View view){
        andcon.sub(this,"ProductBasket");
    }

}
