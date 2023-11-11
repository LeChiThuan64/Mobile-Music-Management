package com.example.quanlyamnhac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterCaSi extends ArrayAdapter {
    Context context;
    int resource;
    List<CaSi> data;

    public AdapterCaSi(@NonNull Context context, int resource, @NonNull List<CaSi> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource,null);
        TextView tvMaCS = convertView.findViewById(R.id.macasi);
        TextView tvTenCaSi = convertView.findViewById(R.id.tencasi);
        TextView ngaySinh = convertView.findViewById(R.id.ngaysinh);
        TextView quocTich = convertView.findViewById(R.id.quoctich);
        TextView gioiTinh = convertView.findViewById(R.id.gioitinh);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);

        CaSi Casi = data.get(position);
        tvMaCS.setText(Casi.getMaCS());
        tvTenCaSi.setText(Casi.getTenCS());
        ngaySinh.setText(Casi.getNgaySinh());
        quocTich.setText(Casi.getQuocTich());
        gioiTinh.setText(Casi.getGioiTinh());

        if(Casi.getTheLoai().equals("Nhạc Bé")) {
            ivHinh.setImageResource(R.drawable.nhacbe);
        }
        if(Casi.getTheLoai().equals("Nhạc trẻ")) {
            ivHinh.setImageResource(R.drawable.nhactre);
        }
        if(Casi.getTheLoai().equals("Nhạc Xưa")) {
            ivHinh.setImageResource(R.drawable.nhacxua);
        }
        return convertView;
    }
}
