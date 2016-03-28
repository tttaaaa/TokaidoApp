package com.example.yuri.tokaidoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.os.Handler;

public class Hantei_mae extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hantei_mae);
        Intent intent = getIntent();

       new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Hantei_mae.this, Result.class);
                startActivity(intent);

            }
        }, 3000);
    }
}