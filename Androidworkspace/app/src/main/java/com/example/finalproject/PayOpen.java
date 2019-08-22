package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PayOpen extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();
    TextView price;
    RadioGroup payGroup;
    int selectCheck;
    PayBean payBean = new PayBean();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_open);
        price = findViewById(R.id.price);
        payGroup = findViewById(R.id.payGroup);
        price.setText(andcon.sumprice+"");


        payGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.cash:
                        andcon.payBean.setPl_payment("현금");
                        selectCheck =1;
                        break;
                    case R.id.card:
                        andcon.payBean.setPl_payment("카드");
                        selectCheck =1;
                        break;
                }
            }
        });
    }
    public void onclickfinish(View v){
        andcon.sub(this,"EndingPay");
    }
}
