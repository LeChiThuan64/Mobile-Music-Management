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

public class DanhSachBaiHat extends AppCompatActivity {

    ListView lvDanhSach;
    Button btnThem;
     static List<BaiHat> data_bh = new ArrayList<>();
     static AdapterBaiHat adapterBaiHat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danh_sach_bai_hat);
        setConTrol();
        setEvent();
    }

    private void setEvent() {
        Khoitao();
        adapterBaiHat = new AdapterBaiHat(this, R.layout.baihat_item_layout,data_bh);
        lvDanhSach.setAdapter(adapterBaiHat);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DanhSachBaiHat.this, ChiTietBaiHat.class);
                intent.putExtra("item",data_bh.get(position));
                startActivity(intent);
            }
        });

        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                data_bh.remove(1);
                adapterBaiHat.notifyDataSetChanged();
                return false;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachBaiHat.this, ThemBaiHat.class);
                startActivity(intent);

            }

        });
    }

    private void Khoitao() {
        data_bh.add(new BaiHat("bhat1","Bánh mì không","Nhạc Trẻ 1","ĐạtG_DuUyen","ĐạtG_DuUyen","NT1"));
        data_bh.add(new BaiHat("bhat2","Buồn của anh","Nhạc Trẻ 2","ĐạtG","K-ICM_ĐạtG_Masew","NT2"));
        data_bh.add(new BaiHat("bhat3","Bật tình yêu lên","Nhạc Trẻ 3","Hòa Minzy_TDT","TDT","NT3"));
    }

    private void setConTrol() {
         lvDanhSach = findViewById(R.id.lvDanhSach);
         btnThem = findViewById(R.id.btnThem);
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