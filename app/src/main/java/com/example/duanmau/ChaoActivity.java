package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ChaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("PhuongNamBookStore");
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                int waited = 0;
                while(waited < 2000){
                    try {
                        sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    waited+=500;
                }
                Intent intent = new Intent(ChaoActivity.this, DangNhapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        };
        thread.start();
    }
}