package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ProductBasket extends AppCompatActivity {

    AndroidController andcon = AndroidController.getInstance();


    Listsetting.SelectProductAdapter adapter;
    ListView selectprolist;
    TextView sumtxt, qty,price;
    LinearLayout preLay;
    int sum;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_basket);
        sumtxt = findViewById(R.id.sumtxt);
        selectprolist = findViewById(R.id.selectprolist);
        if(adapter == null) {
            andcon.sub(this,"selectProadapter");
        }
        selectprolist.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        selectprolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                qty = view.findViewById(R.id.TvBasketQTY);
                price = view.findViewById(R.id.TvBasketPrice);
                position = i;
                if(preLay != null){
                    preLay.setBackgroundColor(Color.WHITE);
                }
                preLay = view.findViewById(R.id.lay);
                preLay.setBackgroundColor(Color.GRAY);
            }
        });

        for(int i = 0; i < andcon.selectpros.size();i++){
            sum += Integer.parseInt(andcon.selectpros.get(i).getPr_price());
        }


        sumtxt.setText(sum+"");
    }

    public void itemQTy(View v){
        switch (v.getId()){
            case R.id.plus:
                int oriprice = 0;
                if(andcon.selectpros.get(position).getPr_qty()!=0) {
                    oriprice = Integer.parseInt(andcon.selectpros.get(position).getPr_price()) / andcon.selectpros.get(position).getPr_qty();
                }else{
                    for(int i =0 ;i < andcon.cateProduct.size();i++){
                        if(andcon.cateProduct.get(i).getPr_id().equals(andcon.selectpros.get(position).getPr_id())){
                            oriprice = Integer.parseInt(andcon.cateProduct.get(i).getPr_price());
                        }
                    }
                }
                andcon.selectpros.get(position).setPr_qty(andcon.selectpros.get(position).getPr_qty()+1);
                andcon.selectpros.get(position).setPr_price((Integer.parseInt(andcon.selectpros.get(position).getPr_price())+oriprice)+"");
                qty.setText(andcon.selectpros.get(position).getPr_qty()+"");
                price.setText(andcon.selectpros.get(position).getPr_price());
                sum += oriprice;
                sumtxt.setText(sum+"");
                break;
            case  R.id.minus:
                if(andcon.selectpros.get(position).getPr_qty() !=0) {
                    int oriprice1 = Integer.parseInt(andcon.selectpros.get(position).getPr_price()) / andcon.selectpros.get(position).getPr_qty();
                    andcon.selectpros.get(position).setPr_qty(andcon.selectpros.get(position).getPr_qty() - 1);
                    andcon.selectpros.get(position).setPr_price((Integer.parseInt(andcon.selectpros.get(position).getPr_price()) - oriprice1) + "");
                    qty.setText(andcon.selectpros.get(position).getPr_qty() + "");
                    price.setText(andcon.selectpros.get(position).getPr_price());
                    sum -= oriprice1;
                    sumtxt.setText(sum+"");
                }

                break;
        }
    }

    public void PayOpen(View v){
        andcon.sumprice = sum;
        andcon.sub(this,"PayOpen");
    }
}
