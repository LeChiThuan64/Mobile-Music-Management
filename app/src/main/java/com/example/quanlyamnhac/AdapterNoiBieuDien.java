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

public class AdapterNoiBieuDien extends ArrayAdapter {
    Context context;
    int resource;
    List<NoiBieuDien> data;

    public AdapterNoiBieuDien(@NonNull Context context, int resource, @NonNull List<NoiBieuDien> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource,null);
        TextView tvTenCS = convertView.findViewById(R.id.tvTenCS);
        TextView tvGiaGiat = convertView.findViewById(R.id.tvGioGiat);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        NoiBieuDien noiBieuDien = data.get(position);
        tvTenCS.setText(noiBieuDien.getTenCSBD());
        tvGiaGiat.setText(noiBieuDien.getGioGiat());

        if(noiBieuDien.getLoaiNoiBieuDien().equals("Hà Nội")) {
            ivHinh.setImageResource(R.drawable.hanoi);
        }
        if(noiBieuDien.getLoaiNoiBieuDien().equals("Đà Nẳng")) {
            ivHinh.setImageResource(R.drawable.danang);
        }
        if(noiBieuDien.getLoaiNoiBieuDien().equals("TP.Hồ Chí Minh")) {
            ivHinh.setImageResource(R.drawable.landmark81);
        }
        return convertView;
    }
}
