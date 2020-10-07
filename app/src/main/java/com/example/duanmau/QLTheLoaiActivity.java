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
import com.example.duanmau.Adapter.TheLoaiAdapter;
import com.example.duanmau.Database.Database;
import com.example.duanmau.Database.TypeDAO;
import com.example.duanmau.Database.UserDAO;
import com.example.duanmau.Model.NguoiDung;
import com.example.duanmau.Model.TheLoai;

import java.util.List;

public class QLTheLoaiActivity extends AppCompatActivity {
    private ListView listView;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_the_loai);
        listView = findViewById(R.id.lvTheLoai);
        database = new Database(this);
        TypeDAO typeDAO = new TypeDAO(database);
        List<TheLoai> theLoaiList = typeDAO.getAllTheLoai();
        TheLoaiAdapter theLoaiAdapter = new TheLoaiAdapter(theLoaiList);
        listView.setAdapter(theLoaiAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ql_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.themMenu){
            Intent intent = new Intent(QLTheLoaiActivity.this, ThemTheLoaiActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.suaMenu){
            Intent intent = new Intent(QLTheLoaiActivity.this, SuaTheLoaiActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}