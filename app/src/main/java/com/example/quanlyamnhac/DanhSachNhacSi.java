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

public class DanhSachNhacSi extends AppCompatActivity {

    ListView lvDanhSach;
    Button btnThem;
    static List<NhacSi> data_ns = new ArrayList<>();
    static AdapterNhacSi adapterNhacSi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_nhac_si);
        setConTrol();
        setEvent();
    }

    private void setEvent() {
        Khoitao();
        adapterNhacSi = new AdapterNhacSi(this, R.layout.nhacsi_item_layout, data_ns);
        lvDanhSach.setAdapter(adapterNhacSi);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DanhSachNhacSi.this, ChiTietNhacSi.class);
                intent.putExtra("item", data_ns.get(position));
                startActivity(intent);
            }
        });

        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                data_ns.remove(1);
                adapterNhacSi.notifyDataSetChanged();
                return false;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachNhacSi.this, ThemNhacSi.class);
                startActivity(intent);

            }

        });
    }

    private void Khoitao() {
        data_ns.add(new NhacSi("ns1", "ĐạtG", "1999", "Nam", "NT1"));
        data_ns.add(new NhacSi("ns2", "M-TP", "1999", "Nam", "NT2"));
        data_ns.add(new NhacSi("ns3", "Mono", "1999", "Nam", "NT3"));
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