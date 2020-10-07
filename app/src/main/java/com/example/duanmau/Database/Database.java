package com.example.duanmau.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database( Context context ) {
        super(context, "data.sql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String table_user = "Create table User(userName nvarchar(50) primary key not null, passWord nvarchar(50), hoTen nvarchar(50), phone real)";
        String table_book = "Create table Book(maSach nchar(5) primary key not null, tenTheLoai nchar(50), tenSach nvarchar(50), tacGia nvarchar(50), NXB nvarchar(50), giaBia float not null, soLuong int not null)";
        String table_type = "Create table Type(maTheLoai char(5) primary key not null, tenTheLoai nvarchar(50), moTa nvarchar(225), viTri nvarchar(50))";
        String table_bill = "Create table Bill(maHoaDon char(5) primary key not null, maSach nchar(5), soLuong int, ngayTao real )";
        sqLiteDatabase.execSQL(table_user);
        sqLiteDatabase.execSQL(table_book);
        sqLiteDatabase.execSQL(table_type);
        sqLiteDatabase.execSQL(table_bill);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
