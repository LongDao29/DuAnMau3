package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duanmau.Database.BookDAO;
import com.example.duanmau.Database.Database;
import com.example.duanmau.Model.Sach;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class ThemSachActivity extends AppCompatActivity {
    ImageView imgThemSach;
    TextInputLayout edtThemMaSach, edtThemTenSach, edtThemTacGia, edtThemNXB, edtThemSoLuongNhap, edtThemDonGia;
    Spinner spnThemTheLoai;
    Button btnThemSach, btnClearThemSach;
    Database database = new Database(this);
    BookDAO bookDAO = new BookDAO(database);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);
        imgThemSach = findViewById(R.id.imgThemSach);
        edtThemMaSach = findViewById(R.id.edtThemMaSach);
        edtThemTenSach = findViewById(R.id.edtThemTenSach);
        edtThemTacGia = findViewById(R.id.edtThemTacGia);
        edtThemNXB = findViewById(R.id.edtThemNXB);
        edtThemSoLuongNhap = findViewById(R.id.edtThemSoLuongSachNhap);
        edtThemDonGia = findViewById(R.id.edtThemDonGia);
        spnThemTheLoai = findViewById(R.id.spnTheLoai);
        btnThemSach = findViewById(R.id.btnThemSach);
        btnClearThemSach = findViewById(R.id.btnClearThemSach);
        ArrayList<String> arrayTheLoai = new ArrayList<>();
        arrayTheLoai.add("Toan Hoa");
        arrayTheLoai.add("Khoa Hoc");
        arrayTheLoai.add("Tin Hoc");
        arrayTheLoai.add("Van Hoc");
        arrayTheLoai.add("Lich su");
        arrayTheLoai.add("Dia ly");
        arrayTheLoai.add("Trinh tham");
        arrayTheLoai.add("Phap luat");
        arrayTheLoai.add("truyen tranh");
        arrayTheLoai.add("Ngoai ngu");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayTheLoai);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnThemTheLoai.setAdapter(adapter);
        imgThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemSachActivity.this, ThemTheLoaiActivity.class);
                startActivity(intent);
            }
        });
        btnClearThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtThemMaSach.getEditText().setText("");
                spnThemTheLoai.setSelection(0);
                edtThemTenSach.getEditText().setText("");
                edtThemTacGia.getEditText().setText("");
                edtThemNXB.getEditText().setText("");
                edtThemSoLuongNhap.getEditText().setText("");
                edtThemDonGia.getEditText().setText("");
            }
        });
        btnThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check()<0){
                    Toast.makeText(getApplicationContext(), "Them that bai", Toast.LENGTH_SHORT).show();
                }
                else {
                    Sach sach = new Sach();
                    sach.maSach = edtThemMaSach.getEditText().getText().toString();
                    sach.tenTheLoai = spnThemTheLoai.getSelectedItem().toString();
                    sach.tenSach = edtThemTenSach.getEditText().getText().toString();
                    sach.tacGia = edtThemTacGia.getEditText().getText().toString();
                    sach.nhaXB = edtThemNXB.getEditText().getText().toString();
                    sach.soLuong = Integer.parseInt(edtThemSoLuongNhap.getEditText().toString());
                    sach.donGia = Double.parseDouble(edtThemDonGia.getEditText().toString());
                    boolean ketQua = bookDAO.themSach(sach);
                    if(ketQua){
                        Toast.makeText(getApplicationContext(), "Them thanh cong", Toast.LENGTH_SHORT).show();

                    }
                    else
                        Toast.makeText(getApplicationContext(), "Them that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public int check(){
        if(edtThemMaSach.getEditText().length()==0){
            edtThemMaSach.setError("Không được để trống");
            return -1;
        }
        else if(edtThemMaSach.getEditText().length()!=0){
            edtThemMaSach.setError("");
        }
        if(edtThemTenSach.getEditText().length()==0){
            edtThemTenSach.setError("Không được để trống");
            return -1;
        }
        else if(edtThemTenSach.getEditText().length()!=0){
            edtThemTenSach.setError("");
        }
        if(edtThemTacGia.getEditText().length()==0){
            edtThemTacGia.setError("Không được để trống");
            return -1;
        }
        else if(edtThemTacGia.getEditText().length()!=0){
            edtThemTacGia.setError("");
        }
        if(edtThemNXB.getEditText().length()==0){
            edtThemNXB.setError("Không được để trống");
            return -1;
        }
        else if(edtThemNXB.getEditText().length()!=0){
            edtThemNXB.setError("");
        }
        if(edtThemSoLuongNhap.getEditText().length()==0){
            edtThemSoLuongNhap.setError("Không được để trống");
            return -1;
        }
        else if(edtThemSoLuongNhap.getEditText().length()!=0){
            edtThemSoLuongNhap.setError("");
        }
        if(edtThemDonGia.getEditText().length()==0){
            edtThemDonGia.setError("Không được để trống");
            return -1;
        }
        else if(edtThemDonGia.getEditText().length()!=0){
            edtThemDonGia.setError("");
        }
        return 1;
    }
}