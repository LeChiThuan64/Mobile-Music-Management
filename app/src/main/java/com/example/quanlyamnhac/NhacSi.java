package com.example.quanlyamnhac;

import java.io.Serializable;

public class NhacSi implements Serializable {
    String maNS, tenNS, namSinh, gioiTinh, theLoai;

    public NhacSi() {
    }

    public NhacSi(String maNS, String tenNS, String namSinh, String gioiTinh, String theLoai) {
        this.maNS = maNS;
        this.tenNS = tenNS;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.theLoai = theLoai;
    }

    public String getMaNS() {
        return maNS;
    }

    public void setMaNS(String maNS) {
        this.maNS = maNS;
    }

    public String getTenNS() {
        return tenNS;
    }

    public void setTenNS(String tenNS) {
        this.tenNS = tenNS;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
