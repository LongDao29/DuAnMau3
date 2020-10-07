package com.example.duanmau.Model;

public class HoaDon {
    public String maHD, maSach, ngayTao;
    public int soLuong;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maSach, String ngayTao, int soLuong) {
        this.maHD = maHD;
        this.maSach = maSach;
        this.ngayTao = ngayTao;
        this.soLuong = soLuong;

    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
