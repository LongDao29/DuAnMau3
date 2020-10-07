package com.example.duanmau.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Database database;

    public BookDAO(Database database) {
        this.database = database;
    }
    public boolean themSach(Sach sach){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maSach", sach.maSach);
        contentValues.put("tenTheLoai", sach.tenTheLoai);
        contentValues.put("tenSach", sach.tenSach);
        contentValues.put("tacGia", sach.tacGia);
        contentValues.put("NXB", sach.nhaXB);
        contentValues.put("soLuong", sach.soLuong);
        contentValues.put("giaBia", sach.donGia);
        long ketQua = sqLiteDatabase.insert("Book", null, contentValues);
        if(ketQua>0) return true;
        else return false;
    }
    public boolean suaSach(Sach sach){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maSach", sach.maSach);
        contentValues.put("tenTheLoai", sach.tenTheLoai);
        contentValues.put("tenSach", sach.tenSach);
        contentValues.put("tacGia", sach.tacGia);
        contentValues.put("NXB", sach.nhaXB);
        contentValues.put("soLuong", sach.soLuong);
        contentValues.put("giaBia", sach.donGia);
        long ketQua = sqLiteDatabase.update("Book", contentValues, "maSach=?", new String[]{sach.maSach});
        if(ketQua>0) return true;
        else return false;
    }
    public boolean xoaSach(String maSach){
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        long ketQua = sqLiteDatabase.delete("Book", "maSach=?", new String[]{maSach});
        if(ketQua>0) return true;
        else return false;
    }
    public List<Sach> getAllBook(){
        List<Sach> sachList = new ArrayList<>();
        String truyVan = "Select * from Book";

        Cursor cursor = database.getWritableDatabase().rawQuery(truyVan, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.isAfterLast()==false){
                String maSach = cursor.getString(cursor.getColumnIndex("maSach"));
                String tenTheLoai = cursor.getString(cursor.getColumnIndex("tenTheLoai"));
                String tenSach = cursor.getString(cursor.getColumnIndex("tenSach"));
                String tacGia = cursor.getString(cursor.getColumnIndex("tacGia"));
                String NXB = cursor.getString(cursor.getColumnIndex("NXB"));
                int soLuong = cursor.getInt(cursor.getColumnIndex("soLuong"));
                double donGia = cursor.getDouble(cursor.getColumnIndex("giaBia"));
                Sach sach = new Sach(maSach, tenTheLoai,tenSach, tacGia, NXB, soLuong, donGia);
                sachList.add(sach);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sachList;
    }
}
