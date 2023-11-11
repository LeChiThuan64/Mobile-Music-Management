package com.example.quanlyamnhac;

import java.io.Serializable;

public class BaiHat implements Serializable {
    String maBH, tenBH, theLoai, caSi, nSST, loaiNhac;

    public BaiHat() {
    }

    public BaiHat(String maBH, String tenBH, String theLoai, String caSi, String nSST, String loaiNhac) {
        this.maBH = maBH;
        this.tenBH = tenBH;
        this.theLoai = theLoai;
        this.caSi = caSi;
        this.nSST = nSST;
        this.loaiNhac = loaiNhac;
    }

    public String getMaBH() {
        return maBH;
    }

    public void setMaBH(String maBH) {
        this.maBH = maBH;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public String getnSST() {
        return nSST;
    }

    public void setnSST(String nSST) {
        this.nSST = nSST;
    }

    public String getLoaiNhac() {
        return loaiNhac;
    }

    public void setLoaiNhac(String loaiNhac) {
        this.loaiNhac = loaiNhac;
    }
}
