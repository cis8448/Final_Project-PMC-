package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class Certification extends AppCompatActivity {


    AndroidController andcon = AndroidController.getInstance();
    LinearLayout visi1, visi2;
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

    }

    public void send(View view) {

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
}