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
import com.example.duanmau.Adapter.SachAdapter;
import com.example.duanmau.Database.BookDAO;
import com.example.duanmau.Database.Database;
import com.example.duanmau.Database.UserDAO;
import com.example.duanmau.Model.NguoiDung;
import com.example.duanmau.Model.Sach;

import java.util.List;

public class QLSachActivity extends AppCompatActivity {
    private ListView listView;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_sach);
        listView = findViewById(R.id.lvSach);
        database = new Database(this);
        BookDAO bookDAO = new BookDAO(database);
        List<Sach> sachList = bookDAO.getAllBook();
        SachAdapter sachAdapter = new SachAdapter(sachList);
        listView.setAdapter(sachAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ql_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.themMenu){
            Intent intent = new Intent(QLSachActivity.this, ThemSachActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.suaMenu){
            Intent intent = new Intent(QLSachActivity.this, SuaSachActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void ButtonXoaSach(View view){

    }
}