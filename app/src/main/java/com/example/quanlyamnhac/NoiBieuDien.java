package com.example.quanlyamnhac;

import java.io.Serializable;

public class NoiBieuDien implements Serializable {
    String maBD, tenCSBD, gioGiat, loaiNoiBieuDien;

    @Override
    public String toString() {
        return "NoiBieuDien{" +
                "maBD='" + maBD + '\'' +
                ", tenCSBD='" + tenCSBD + '\'' +
                ", gioGiat='" + gioGiat + '\'' +
                ", loaiNoiBieuDien='" + loaiNoiBieuDien + '\'' +
                '}';
    }

    public String getMaBD() {
        return maBD;
    }

    public void setMaBD(String maBD) {
        this.maBD = maBD;
    }

    public String getTenCSBD() {
        return tenCSBD;
    }

    public void setTenCSBD(String tenCSBD) {
        this.tenCSBD = tenCSBD;
    }

    public String getGioGiat() {
        return gioGiat;
    }

    public void setGioGiat(String gioGiat) {
        this.gioGiat = gioGiat;
    }

    public String getLoaiNoiBieuDien() {
        return loaiNoiBieuDien;
    }

    public void setLoaiNoiBieuDien(String loaiNoiBieuDien) {
        this.loaiNoiBieuDien = loaiNoiBieuDien;
    }

    public NoiBieuDien(String maBD, String tenCSBD, String gioGiat, String loaiNoiBieuDien) {
        this.maBD = maBD;
        this.tenCSBD = tenCSBD;
        this.gioGiat = gioGiat;
        this.loaiNoiBieuDien = loaiNoiBieuDien;
    }

    public NoiBieuDien() {
    }
}
