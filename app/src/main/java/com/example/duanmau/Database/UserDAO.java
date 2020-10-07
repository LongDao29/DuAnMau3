package com.example.duanmau.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.Model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Database database;

    public UserDAO(Database database) {
        this.database = database;
    }
    public boolean ThemNguoiDung(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", nguoiDung.userName);
        contentValues.put("hoTen", nguoiDung.ten);
        contentValues.put("passWord", nguoiDung.password);
        contentValues.put("phone", nguoiDung.phone);
        long ketQua = sqLiteDatabase.insert("User", null, contentValues);
            if(ketQua>0) return true;
            else return false;
    }
    public boolean suaNguoiDung(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", nguoiDung.userName);
        contentValues.put("hoTen", nguoiDung.ten);
        contentValues.put("passWord", nguoiDung.password);
        contentValues.put("phone", nguoiDung.phone);
        long ketQua = sqLiteDatabase.update("User", contentValues, "userName=?", new String[]{nguoiDung.userName});
        if(ketQua>0) return true;
        else return false;
    }
    public boolean xoaNguoiDung(String id){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        long ketQua = sqLiteDatabase.delete("User", "userName=?", new String[]{id});

        if(ketQua>0) return true;
        else return false;
    }
    public List<NguoiDung> getAllNguoiDung(){
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String truyVan = "Select * from User";
        Cursor cursor = database.getWritableDatabase().rawQuery(truyVan, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                String userName = cursor.getString(cursor.getColumnIndex("userName"));
                String passWord = cursor.getString(cursor.getColumnIndex("passWord"));
                String hoTen = cursor.getString(cursor.getColumnIndex("hoTen"));
                String phone = cursor.getString(cursor.getColumnIndex("phone"));
                NguoiDung nguoiDung = new NguoiDung(userName, passWord, hoTen, phone);
                nguoiDungList.add(nguoiDung);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return nguoiDungList;
    }
}
