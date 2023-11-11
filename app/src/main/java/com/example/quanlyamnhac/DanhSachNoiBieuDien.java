package com.example.quanlyamnhac;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DanhSachNoiBieuDien extends AppCompatActivity {

    ListView lvDanhSach;
    Button btnThem;
     static List<NoiBieuDien> data_nbs = new ArrayList<>();
     static AdapterNoiBieuDien adapterNoiBieuDien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhnoibieudien);
        setConTrol();
        setEvent();
    }

    private void setEvent() {
        Khoitao();
        adapterNoiBieuDien = new AdapterNoiBieuDien(this, R.layout.noibieudien_item_layout, data_nbs);
        lvDanhSach.setAdapter(adapterNoiBieuDien);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DanhSachNoiBieuDien.this, ChiTietNoiBieuDien.class);
                intent.putExtra("item", data_nbs.get(position));
                startActivity(intent);
            }
        });

        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                data_nbs.remove(1);
                adapterNoiBieuDien.notifyDataSetChanged();
                return false;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachNoiBieuDien.this, ThemNoiBieuDien.class);
                startActivity(intent);

            }

        });
    }

    private void Khoitao() {
        data_nbs.add(new NoiBieuDien("bd1","Thuận","10:20","Hà Nội"));
        data_nbs.add(new NoiBieuDien("bd2","Tùng","4:55","Đà Nẳng"));
        data_nbs.add(new NoiBieuDien("bd3","Thiện","6:00","TP.Hồ Chí Minh"));
    }

    private void setConTrol() {
         lvDanhSach = findViewById(R.id.lvDanhSach);
        btnThem = findViewById(R.id.Them);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.button_nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            Intent intent = new Intent(this, TrangChu.class);
            Toast.makeText(this, "Vô Home", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        if (item.getItemId() == R.id.DanhSach) {
            Intent intent = new Intent(this, DanhSach.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.Thoat) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}