package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau.Database.BillDAO;
import com.example.duanmau.Database.Database;
import com.example.duanmau.Model.HoaDon;
import com.google.android.material.textfield.TextInputLayout;

public class ThemHoaDonActivity extends AppCompatActivity {
    TextInputLayout edtThemMaHD, edtThemMS, edtThemSLBan;
    EditText edtChonNgay;
    Button btnThemHD, btnClearThemHD, btnChonNgay;
    Database database = new Database(this);
    BillDAO billDAO = new BillDAO(database);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don);
        edtThemMaHD = findViewById(R.id.edtThemMaHD);
        edtThemMS = findViewById(R.id.edtThemMS);
        edtThemSLBan = findViewById(R.id.edtThemSLBan);
        edtChonNgay = findViewById(R.id.edtNgayTao);
        btnClearThemHD = findViewById(R.id.btnClearThemHD);
        btnThemHD = findViewById(R.id.btnThemHD);
        btnClearThemHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtThemMaHD.getEditText().setText("");
                edtThemMS.getEditText().setText("");
                edtThemSLBan.getEditText().setText("");
                edtChonNgay.setText("01-01-1950");
            }
        });
        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnThemHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check()<0){
                    Toast.makeText(getApplicationContext(), "them khong thnah cong", Toast.LENGTH_SHORT).show();
                }
                else {
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.maHD = edtThemMaHD.getEditText().getText().toString();
                    hoaDon.maSach = edtThemMS.getEditText().getText().toString().trim();
                    hoaDon.soLuong = Integer.parseInt(edtThemSLBan.getEditText().getText().toString().trim());
                    hoaDon.ngayTao = edtChonNgay.getText().toString();
                    boolean ketQua = billDAO.themHoaDon(hoaDon);
                    if(ketQua){
                        Toast.makeText(getApplicationContext(), "them thanh cong", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "them khong thnah cong", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public int check(){
        if(edtThemMaHD.getEditText().length()==0){
            edtThemMaHD.setError("Không được để trống");
            return -1;
        }
        else if(edtThemMaHD.getEditText().length()!=0){
            edtThemMaHD.setError("");
        }
        if(edtThemMS.getEditText().length()==0){
            edtThemMS.setError("Không được để trống");
            return -1;
        }
        else if(edtThemMS.getEditText().length()!=0){
            edtThemMS.setError("");
        }
        if(edtThemSLBan.getEditText().length()==0){
            edtThemSLBan.setError("Không được để trống");
            return -1;
        }
        else if(edtThemSLBan.getEditText().length()!=0){
            edtThemSLBan.setError("");
        }
        return 1;
    }
}