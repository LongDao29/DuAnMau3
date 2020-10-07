package com.example.duanmau.Model;

public class NguoiDung {
    public String  userName, password, ten, phone;

    public NguoiDung() {
    }

    public NguoiDung(String userName, String password, String ten, String phone) {

        this.userName = userName;
        this.password = password;
        this.ten = ten;
        this.phone = phone;
    }




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
