package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.duanmau.Database.Database;
import com.example.duanmau.Database.TypeDAO;
import com.example.duanmau.Model.NguoiDung;
import com.example.duanmau.Model.TheLoai;
import com.google.android.material.textfield.TextInputLayout;

public class ThemTheLoaiActivity extends AppCompatActivity {
    TextInputLayout edtThemMaTheLoai, edtThemTenTheLoai, edtThemViTri, edtThemMota;
    Button btnThemTheLoai, btnClearTheLoai, btnMoDanhSachTheLoai;
    Database database = new Database(this);
    TypeDAO typeDAO = new TypeDAO(database);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_the_loai);
        edtThemMaTheLoai = findViewById(R.id.edtThemMaTheLoai);
        edtThemTenTheLoai = findViewById(R.id.edtThemTenTheLoai);
        edtThemViTri = findViewById(R.id.edtThemVitri);
        edtThemMota = findViewById(R.id.edtThemMota);
        btnClearTheLoai = findViewById(R.id.btnClearThemTheLoai);
        btnThemTheLoai = findViewById(R.id.btnThemTheLoai);
        btnMoDanhSachTheLoai = findViewById(R.id.btnMoDanhSachTheLoai);
        btnMoDanhSachTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemTheLoaiActivity.this, QLTheLoaiActivity.class);
                startActivity(intent);
            }
        });
        btnClearTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtThemMaTheLoai.getEditText().setText("");
                edtThemTenTheLoai.getEditText().setText("");
                edtThemMota.getEditText().setText("");
                edtThemViTri.getEditText().setText("");
            }
        });
        btnThemTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check()<0){
                    Toast.makeText(getApplicationContext(), "Them không thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    TheLoai theLoai = new TheLoai();
                    theLoai.maTheLoai = edtThemMaTheLoai.getEditText().getText().toString();
                    theLoai.tenTheLoai = edtThemTenTheLoai.getEditText().getText().toString();
                    theLoai.viTri = edtThemViTri.getEditText().getText().toString();
                    theLoai.moTa = edtThemMota.getEditText().getText().toString();

                    boolean ketQua = typeDAO.ThemTheLoai(theLoai);
                    if(ketQua){

                        Toast.makeText(getApplicationContext(), "Dang Ky thanh cong", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Dang ky that bai", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
    public int check(){
        if(edtThemMaTheLoai.getEditText().length()==0){
            edtThemMaTheLoai.setError("Không được để trống");
            return -1;
        }
        else if(edtThemMaTheLoai.getEditText().length()!=0){
            edtThemMaTheLoai.setError("");
        }
        if(edtThemViTri.getEditText().length()==0){
            edtThemViTri.setError("Không được để trống");
            return -1;
        }
        else if(edtThemTenTheLoai.getEditText().length()!=0){
            edtThemTenTheLoai.setError("");
        }
        if(edtThemViTri.getEditText().length()==0){
            edtThemViTri.setError("Không được để trống");
            return -1;
        }
        else if(edtThemViTri.getEditText().length()!=0){
            edtThemViTri.setError("");
        }


        return 1;
    }
}