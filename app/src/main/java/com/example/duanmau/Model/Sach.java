package com.example.duanmau.Model;

public class Sach {
    public String maSach, tenTheLoai, tenSach, tacGia, nhaXB;
    public int soLuong;
    public double donGia;

    public Sach() {
    }

    public Sach(String maSach, String tenTheLoai, String tenSach, String tacGia, String nhaXB, int soLuong, double donGia) {
        this.maSach = maSach;
        this.tenTheLoai = tenTheLoai;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXB = nhaXB;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
