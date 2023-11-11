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

public class AdapterBaiHat extends ArrayAdapter {
    Context context;
    int resource;
    List<BaiHat> data;

    public AdapterBaiHat(@NonNull Context context, int resource, @NonNull List<BaiHat> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource,null);
        TextView tvTenBH = convertView.findViewById(R.id.tvTenBH);
        TextView tvTheLoai = convertView.findViewById(R.id.tvTheLoai);
        TextView tvCaSiBD = convertView.findViewById(R.id.tvCaSiBD);
        TextView tvNSST = convertView.findViewById(R.id.tvNSST);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        BaiHat bh = data.get(position);
        tvTenBH.setText(bh.getTenBH());
        tvTheLoai.setText(bh.getTheLoai());
        tvCaSiBD.setText(bh.getTheLoai());
        tvNSST.setText(bh.getnSST());

        if(bh.getLoaiNhac().equals("NT1")) {
            ivHinh.setImageResource(R.drawable.bh1);
        }
        if(bh.getLoaiNhac().equals("NT2")) {
            ivHinh.setImageResource(R.drawable.bh2);
        }
        if(bh.getLoaiNhac().equals("NT3")) {
            ivHinh.setImageResource(R.drawable.bh3);
        }
        return convertView;
    }
}
