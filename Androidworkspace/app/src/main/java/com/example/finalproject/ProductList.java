package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();

    public Bitmap[] productpicture;

    GridView GridProduct;
    TextView TvName;
    TextView TvPrice;
    ImageView ProductImg;
    DrawerLayout DL;
    ImageButton btn1;
    LinearLayout scroll,mainlow2;
    TextView mainlow1;
    ImageButton alarm,info;
    Button loginbtn,logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        GridProduct = findViewById(R.id.GridProduct);
        ProductImg = findViewById(R.id.ProductImg);
        DL = findViewById(R.id.drawlay);
        btn1 = findViewById(R.id.btn1);
        scroll = findViewById(R.id.scroll);
        mainlow2 = findViewById(R.id.mainlow2);
        mainlow1 = findViewById(R.id.mainlow1);
        loginbtn =findViewById(R.id.loginbtn);
        logoutbtn = findViewById(R.id.logoutbtn);
        alarm = findViewById(R.id.alarm);
        info = findViewById(R.id.info);

        //메뉴버튼 클릭시 메뉴창 출력
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DL.openDrawer(Gravity.LEFT);
            }
        });

        if(productpicture == null){
            andcon.sub(this,"getProductPicture");
            ProductImg.setImageBitmap(productpicture[0]);
        }


        //상품을 클릭
        GridProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TvName = view.findViewById(R.id.ProductName);
                TvPrice = view.findViewById(R.id.ProductPrice);
                andcon.sub(ProductList.this,"ProductOrder");
            }
        });
    }

    public void ProductBasket(View view){
        andcon.sub(this,"ProductBasket");
    }
}
