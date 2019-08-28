package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();

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
    Spinner ProductCate;
    public ArrayAdapter arrayAdapter;
    public Listsetting.ProductAdapter productAdapter;
    public ArrayList<ProductBean> selpro = new ArrayList<>();
    public TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        GridProduct = findViewById(R.id.GridProduct);
        ProductImg = findViewById(R.id.ProductImg);
        DL = findViewById(R.id.drawlay);
        btn1 = findViewById(R.id.btn1);
        scroll = findViewById(R.id.scroll);
        mainlow1 = findViewById(R.id.mainlow1);
        loginbtn = findViewById(R.id.loginbtn);
        logoutbtn = findViewById(R.id.logoutbtn);
        info = findViewById(R.id.info);
        ProductCate = findViewById(R.id.ProductCate);


        //카테고리 리스트 없을때 출력
        if(arrayAdapter == null){
            andcon.sub(this,"cateSearch");
        }
        ProductCate.setAdapter(arrayAdapter);

        ProductCate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                andcon.posicate = andcon.cates.get(i);
                andcon.cateProduct.clear();
                andcon.sub(ProductList.this,"mProduct");
                GridProduct.setAdapter(productAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        GridProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                andcon.selectpro=new ProductBean();
                andcon.selectpro.setPr_id(andcon.cateProduct.get(i).getPr_id());
                andcon.selectpro.setPr_name(andcon.cateProduct.get(i).getPr_name());
                andcon.selectpro.setPr_price(andcon.cateProduct.get(i).getPr_price());
                andcon.selectpro.setPr_qty(andcon.cateProduct.get(i).getPr_qty());
                andcon.selectpro.setPr_qty(1);
                andcon.sub(ProductList.this,"ProductAdd");
            }
        });
    }


    public void ProductBasket(View view){

        if(andcon.selectpros.size() == 0){
            Toast.makeText(this, "주문하신 상품이 없습니다.", Toast.LENGTH_SHORT).show();
        }else {
            andcon.sub(this,"ProductBasket");
        }
    }
}