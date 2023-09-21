package com.example.chicolemevipclient;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ScreenSplash extends AppCompatActivity {

    private final Timer mTimer = new Timer();
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gotonHomeActivity();
                    }
                });
            }
        };
        mTimer.schedule(timerTask, 3000);
    }

    private void gotonHomeActivity() {
        Intent mIntent = new Intent(getApplicationContext(), HomeActivity.class);
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mIntent);
        finish();
    }
}
