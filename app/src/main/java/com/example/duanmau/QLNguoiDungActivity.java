package com.example.duanmau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.duanmau.Adapter.NguoiDungAdapter;
import com.example.duanmau.Database.Database;
import com.example.duanmau.Database.UserDAO;
import com.example.duanmau.Model.NguoiDung;

import java.util.List;

public class QLNguoiDungActivity extends AppCompatActivity {
    private ListView listView;
    private Database database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_nguoi_dung);
        listView = findViewById(R.id.listViewND);
        database = new Database(this);
        UserDAO userDAO = new UserDAO(database);
        List<NguoiDung> nguoiDungList = userDAO.getAllNguoiDung();
        NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList);
        listView.setAdapter(nguoiDungAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.qlnd_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

         if(item.getItemId()==R.id.capNhatThongTin){
            Intent intent = new Intent(QLNguoiDungActivity.this, SuaNguoiDungActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.dangXuat){
            Intent intent = new Intent(QLNguoiDungActivity.this, DangNhapActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}