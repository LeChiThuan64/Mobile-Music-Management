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

public class AdapterNhacSi extends ArrayAdapter {
    Context context;
    int resource;
    List<NhacSi> data;

    public AdapterNhacSi(@NonNull Context context, int resource, @NonNull List<NhacSi> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        TextView tvTenNS = convertView.findViewById(R.id.tvTenNhacSi);
        TextView tvNamSinh = convertView.findViewById(R.id.tvNamSinh);
        TextView tvGioiTinh = convertView.findViewById(R.id.tvGioiTinh);

        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        NhacSi ns = data.get(position);
        tvTenNS.setText(ns.getTenNS());
        tvNamSinh.setText(ns.getNamSinh());
        tvGioiTinh.setText(ns.getGioiTinh());


        if (ns.getTheLoai().equals("NT1")) {
            ivHinh.setImageResource(R.drawable.ns1);
        }
        if (ns.getTheLoai().equals("NT2")) {
            ivHinh.setImageResource(R.drawable.ns2);
        }
        if (ns.getTheLoai().equals("NT3")) {
            ivHinh.setImageResource(R.drawable.ns3);
        }
        return convertView;
    }
}
