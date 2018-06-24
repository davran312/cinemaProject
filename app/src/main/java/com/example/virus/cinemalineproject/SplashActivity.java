package com.example.virus.cinemalineproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(SplashActivity.this, TheatreListActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException ex) {
                }
            }
        };
        thread.start();
    }
}