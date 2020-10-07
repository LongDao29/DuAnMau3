package com.example.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau.Database.Database;
import com.example.duanmau.Database.UserDAO;
import com.example.duanmau.Model.NguoiDung;
import com.google.android.material.textfield.TextInputLayout;

public class DangKyActivity extends AppCompatActivity {
    TextInputLayout edtHoTenDK, edtUserNameDk, edtPassDK, edtRePassDK, edtSDTDK;
    Button btnDanKyDK, btnClearDK;
    Database database = new Database(this);
    UserDAO userDAO = new UserDAO(database);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        setTitle("Đăng ký");
        edtHoTenDK = findViewById(R.id.edtHoTenDK);
        edtUserNameDk = findViewById(R.id.edtUserNameDK);
        edtPassDK = findViewById(R.id.edtPassDK);

        edtSDTDK = findViewById(R.id.edtSDTDK);
        btnDanKyDK = findViewById(R.id.btnDangKyDK);
        btnClearDK = findViewById(R.id.btnClearDK);
        btnClearDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtHoTenDK.getEditText().setText("");
                edtUserNameDk.getEditText().setText("");
                edtPassDK.getEditText().setText("");
                edtRePassDK.getEditText().setText("");
                edtSDTDK.getEditText().setText("");
            }
        });
        btnDanKyDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check()<0){
                    Toast.makeText(getApplicationContext(), "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    NguoiDung nguoiDung = new NguoiDung();
                    nguoiDung.userName = edtUserNameDk.getEditText().getText().toString();
                    nguoiDung.ten = edtHoTenDK.getEditText().getText().toString();
                    nguoiDung.password = edtPassDK.getEditText().getText().toString();
                    nguoiDung.phone = edtSDTDK.getEditText().getText().toString();

                    boolean ketQua = userDAO.ThemNguoiDung(nguoiDung);
                    if(ketQua){

                        Toast.makeText(getApplicationContext(), "Dang Ky thanh cong", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(DangKyActivity.this, DangNhapActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Dang ky that bai", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });
    }

    public int check(){
        if(edtHoTenDK.getEditText().length()==0){
            edtHoTenDK.setError("Không được để trống");
            return -1;
        }
        else if(edtHoTenDK.getEditText().length()!=0){
            edtHoTenDK.setError("");
        }
        if(edtUserNameDk.getEditText().length()==0){
            edtUserNameDk.setError("Không được để trống");
            return -1;
        }
        else if(edtUserNameDk.getEditText().length()!=0){
            edtUserNameDk.setError("");
        }
        if(edtPassDK.getEditText().length()==0){
            edtPassDK.setError("Không được để trống");
            return -1;
        }
        else if(edtPassDK.getEditText().length()!=0){
            edtPassDK.setError("");
        }
        if(edtSDTDK.getEditText().length()==0){
            edtSDTDK.setError("Không được để trống");
            return -1;
        }
        else if(edtSDTDK.getEditText().length()!=0){
            edtSDTDK.setError("");
        }
        if(edtSDTDK.getEditText().length()!=10){
            edtSDTDK.setError("Không được để trống");
            return -1;
        }
        else if(edtSDTDK.getEditText().length()!=0){
            edtSDTDK.setError("");
        }

        return 1;
    }

}