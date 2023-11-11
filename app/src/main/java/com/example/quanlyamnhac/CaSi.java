package com.example.quanlyamnhac;

import java.io.Serializable;

public class CaSi implements Serializable {
    String maCS,tenCS,ngaySinh,quocTich,theLoai,gioiTinh;

    @Override
    public String toString() {
        return "CaSi{" +
                "maCS='" + maCS + '\'' +
                ", tenCS='" + tenCS + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", quocTich='" + quocTich + '\'' +
                ", theLoai='" + theLoai + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                '}';
    }

    public String getMaCS() {
        return maCS;
    }

    public void setMaCS(String maCS) {
        this.maCS = maCS;
    }

    public String getTenCS() {
        return tenCS;
    }

    public void setTenCS(String tenCS) {
        this.tenCS = tenCS;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public CaSi(String maCS, String tenCS, String ngaySinh, String quocTich, String theLoai, String gioiTinh) {
        this.maCS = maCS;
        this.tenCS = tenCS;
        this.ngaySinh = ngaySinh;
        this.quocTich = quocTich;
        this.theLoai = theLoai;
        this.gioiTinh = gioiTinh;
    }

    public CaSi() {
    }
}
