package com.example.duanmau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.duanmau.Adapter.HoaDonAdapter;
import com.example.duanmau.Adapter.NguoiDungAdapter;
import com.example.duanmau.Database.BillDAO;
import com.example.duanmau.Database.Database;
import com.example.duanmau.Database.UserDAO;
import com.example.duanmau.Model.HoaDon;
import com.example.duanmau.Model.NguoiDung;

import java.util.List;

public class QLHoaDonActivity extends AppCompatActivity {
    private ListView listView;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_hoa_don);
        listView = findViewById(R.id.lvHoaDon);
        database = new Database(this);
        BillDAO billDAO = new BillDAO(database);
        List<HoaDon> hoaDonList = billDAO.getAllHoaDon();
        HoaDonAdapter hoaDonAdapter = new HoaDonAdapter(hoaDonList);
        listView.setAdapter(hoaDonAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ql_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.themMenu){
            Intent intent = new Intent(QLHoaDonActivity.this, ThemHoaDonActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.suaMenu){
            Intent intent = new Intent(QLHoaDonActivity.this, SuaHoaDonActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void ButtonXoaHoaDon(View view){

    }
}