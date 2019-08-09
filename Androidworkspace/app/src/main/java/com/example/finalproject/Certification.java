package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Certification extends AppCompatActivity {

    public String Cernumber;

    AndroidController andcon = AndroidController.getInstance();
    LinearLayout visi1, visi2;
    EditText ceredt;
    private TextView downcount;

    private static final long TIMER_DURATION = 10000L;
    private static final long TIMER_INTERVAL = 1000L;

    private CountDownTimer mCountDownTimer;

    private long mTimeRemaining;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);

        downcount = findViewById(R.id.downcount);
        visi1 = findViewById(R.id.visi1);
        visi2 = findViewById(R.id.visi2);
        ceredt = findViewById(R.id.ceredt);
    }

    public void send(View view) {
        Random random = new Random();
        Cernumber = random.nextInt(99999)+"";
        andcon.sub(this,"send");

        view.setEnabled(false);
        mCountDownTimer = new CountDownTimer(TIMER_DURATION, TIMER_INTERVAL) {

            @Override
            public void onTick(long millisUntilFinished) {
                downcount.setText(String.format(Locale.getDefault(), "%d"+"초", millisUntilFinished / 1000L));
                mTimeRemaining = millisUntilFinished; // Saving timeRemaining in Activity for pause/resume of CountDownTimer.
            }

            @Override
            public void onFinish() {
                downcount.setText("인증시간 만료");
                Cernumber = null;
            }
        }.start();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mCountDownTimer == null) { // Timer was paused, re-create with saved time.
            mCountDownTimer = new CountDownTimer(mTimeRemaining, TIMER_INTERVAL) {
                @Override
                public void onTick(long millisUntilFinished) {
                    downcount.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                    mTimeRemaining = millisUntilFinished;
                }

                @Override
                public void onFinish() {
                    downcount.setText("Done.");
                }
            }.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCountDownTimer.cancel();
        mCountDownTimer = null;
    }
    public void cerin(View v){
        String count = downcount.getText().toString();
        String edt = ceredt.getText().toString();
        if(!count.equals("인증시간 만료")){
            if(Cernumber.equals(edt)) {
                andcon.sub(this, "getIdOpen");
            }else{
                Toast.makeText(this, "인증번호가 틀렷습니다 다시 입력해 주세요", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "인증시간이 만료되었습니다. 재발송을 해주세요", Toast.LENGTH_SHORT).show();
        }
    }
}