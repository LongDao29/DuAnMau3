package com.example.duanmau.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.Model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TypeDAO  {
    private Database database;

    public TypeDAO(Database database) {
        this.database = database;
    }
    public boolean ThemTheLoai(TheLoai theLoai){

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTheLoai", theLoai.maTheLoai);
        contentValues.put("tenTheLoai", theLoai.tenTheLoai);
        contentValues.put("moTa", theLoai.moTa);
        contentValues.put("viTri", theLoai.viTri);
        long ketQua = sqLiteDatabase.insert("Type", null, contentValues);
        if(ketQua>0) return true;
        else return false;
    }
    public boolean SuaTheLoai(TheLoai theLoai){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTheLoai", theLoai.maTheLoai);
        contentValues.put("tenTheLoai", theLoai.tenTheLoai);
        contentValues.put("moTa", theLoai.moTa);
        contentValues.put("viTri", theLoai.viTri);
        long ketQua = sqLiteDatabase.update("Type", contentValues, "maTheLoai=?", new String[]{theLoai.maTheLoai});
        if(ketQua>0) return true;
        else return false;
    }
    public boolean xoaTheLoai(String maTheLoai){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        long ketQua = sqLiteDatabase.delete("Type", "maTheLoai=?", new String[]{maTheLoai});

        if(ketQua>0) return true;
        else return false;
    }
    public List<TheLoai> getAllTheLoai(){
        List<TheLoai> theLoaiList = new ArrayList<>();
        String truyVan = "Select * from Type";
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        Cursor cursor = database.getWritableDatabase().rawQuery(truyVan, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                String maTheLoai = cursor.getString(cursor.getColumnIndex("maTheLoai"));
                String tenTheLoai = cursor.getString(cursor.getColumnIndex("tenTheLoai"));
                String moTa = cursor.getString(cursor.getColumnIndex("moTa"));
                String viTri = cursor.getString(cursor.getColumnIndex("viTri"));
                TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai, moTa, viTri);
                theLoaiList.add(theLoai);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return theLoaiList;
    }
}
