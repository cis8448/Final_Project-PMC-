package com.example.finalproject;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyInfoUpdate extends AppCompatActivity {


    AndroidController andcon = AndroidController.getInstance();
    EditText mtx1, mtx2, mtx3;
    Button mybtn2;
    TextView mtx, tttx;
    MemberBean mb = new MemberBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info_update);

        tttx = findViewById(R.id.tttx);
        mtx = findViewById(R.id.mtx);
        mtx1 = findViewById(R.id.mtx1);
        mtx2 = findViewById(R.id.mtx2);
        mtx3 = findViewById(R.id.mtx3);


        mybtn2 = findViewById(R.id.mybtn2);


        mtx.setText(andcon.member.getM_name());

        mtx1.setHint(andcon.member.getM_nickname());
        mtx2.setHint(andcon.member.getM_email());
        mtx3.setHint(andcon.member.getM_phone());
        String str[];
        str = andcon.member.getM_birthday().split("_");
        int a = Integer.parseInt(str[1]);
        if (a >= 20) {
            tttx.setText("성인 회원입니다");
        } else {
            tttx.setText("미성년자 회원입니다.");
        }

        mybtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mtx1.getText().toString().equals("")) {
                    mb.setM_nickname(mtx1.getText().toString());
                } else {
                    mb.setM_nickname(andcon.member.getM_nickname());
                }

                if (!mtx2.getText().toString().equals("")) {
                    mb.setM_email(mtx2.getText().toString());
                } else {
                    mb.setM_email(andcon.member.getM_email());
                }

                if (!mtx3.getText().toString().equals("")) {
                    mb.setM_phone(mtx3.getText().toString());
                } else {
                    mb.setM_phone(andcon.member.getM_phone());
                }
                andcon.sub(MyInfoUpdate.this, "MyInfoUpdate");
            }
        });

    }
}
