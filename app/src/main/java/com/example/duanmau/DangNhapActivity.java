package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class DangNhapActivity extends AppCompatActivity {
    TextInputLayout tipUserDN, tipPassDN;
    Button btnDangNhap, btnDangKy, btnClearDN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        setTitle("Đăng nhập");
        tipUserDN = findViewById(R.id.tipUserDN);
        tipPassDN = findViewById(R.id.tipPassDN);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnClearDN = findViewById(R.id.btnClearDN);
        btnClearDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipUserDN.getEditText().setText("");
                tipPassDN.getEditText().setText("");
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check()<0){
                    Toast.makeText(getApplicationContext(), "Dang nhap that bai", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DangNhapActivity.this, TrangChuActivity.class);
                    startActivity(intent);
                }
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });
    }
    public int check(){
        if(tipUserDN.getEditText().length()==0){
            tipUserDN.setError("Không được để trống");
            return -1;
        }
        else {
            tipUserDN.setError("");

        }
        if(tipPassDN.getEditText().length()==0){
            tipPassDN.setError("Không được để trống");
            return -1;
        }
        else {
            tipPassDN.setError("");
        }
        return 1;
    }

}