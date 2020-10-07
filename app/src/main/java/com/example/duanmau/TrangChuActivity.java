package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TrangChuActivity extends AppCompatActivity {
    ImageView imgNguoiDung, imgTheLoai, imgSach, imgHoaDon, imgSachBanChay, imgDoanhSo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        setTitle("Phương Nam ");
        imgDoanhSo = findViewById(R.id.imgDoanhSo);
        imgNguoiDung = findViewById(R.id.imgNguoiDung);
        imgTheLoai = findViewById(R.id.imgTheLoai);
        imgSach = findViewById(R.id.imgSach);
        imgHoaDon = findViewById(R.id.imgHoaDon);
        imgSachBanChay = findViewById(R.id.imgSachBanChay);
        imgNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChuActivity.this, QLNguoiDungActivity.class);
                startActivity(intent);
            }
        });
        imgTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChuActivity.this, QLTheLoaiActivity.class);
                startActivity(intent);
            }
        });
        imgSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChuActivity.this, QLSachActivity.class);
                startActivity(intent);
            }
        });
        imgHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChuActivity.this, QLHoaDonActivity.class);
                startActivity(intent);
            }
        });
        imgSachBanChay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChuActivity.this, TKSachBanChayActivity.class);
                startActivity(intent);
            }
        });
        imgDoanhSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChuActivity.this, ThongKeDoanhSoActivity.class);
                startActivity(intent);
            }
        });
    }
}