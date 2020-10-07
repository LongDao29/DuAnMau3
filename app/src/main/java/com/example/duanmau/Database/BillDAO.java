package com.example.duanmau.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.Model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    private Database database;

    public BillDAO(Database database) {
        this.database = database;
    }
    public boolean themHoaDon(HoaDon hoaDon){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon", hoaDon.maHD);
        contentValues.put("maSach", hoaDon.maSach);
        contentValues.put("ngayTao", hoaDon.ngayTao);
        contentValues.put("soLuong", hoaDon.soLuong);
        long ketQua = sqLiteDatabase.insert("Bill", null, contentValues);
        if(ketQua>0) return true;
        else return false;
    }
    public boolean suaHoaDon(HoaDon hoaDon){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon", hoaDon.maHD);
        contentValues.put("maSach", hoaDon.maSach);
        contentValues.put("ngayTao", hoaDon.ngayTao);
        contentValues.put("soLuong", hoaDon.soLuong);
        long ketQua = sqLiteDatabase.update("Bill", contentValues, "maHoaDon=?", new String[]{hoaDon.maHD});
        if(ketQua>0) return true;
        else return false;
    }
    public boolean xoaHoaDon(String maHoaDon){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        long ketQua = sqLiteDatabase.delete("Bill", "maHoaDon=?", new String[]{maHoaDon});

        if(ketQua>0) return true;
        else return false;
    }
    public List<HoaDon> getAllHoaDon(){
        List<HoaDon> hoaDonList = new ArrayList<>();
        String truyVan = "Select * from Bill";
        Cursor cursor = database.getWritableDatabase().rawQuery(truyVan, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                String maHoaDon = cursor.getString(cursor.getColumnIndex("maHoaDon"));
                String maSach = cursor.getString(cursor.getColumnIndex("maSach"));
                String ngayTao = cursor.getString(cursor.getColumnIndex("ngayTao"));
                int soLuong = cursor.getInt(cursor.getColumnIndex("soLuong"));
                HoaDon hoaDon = new HoaDon(maHoaDon, maSach, ngayTao, soLuong);
                hoaDonList.add(hoaDon);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return hoaDonList;
    }
}
