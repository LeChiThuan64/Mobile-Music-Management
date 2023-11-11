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

public class DanhSachCaSi extends AppCompatActivity {
    ListView lvDanhSach;
    Button btnThem;
    static List<CaSi> data_cs = new ArrayList<>();

    static AdapterCaSi adapterCaSi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControll();
        setEvent();

    }

    private void setEvent() {
        khoitao();
        adapterCaSi = new AdapterCaSi(this, R.layout.casi_item_layout, data_cs);
        lvDanhSach.setAdapter(adapterCaSi);


        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(DanhSachCaSi.this, ChiTiecCaSi.class);
                intent.putExtra("caSi", data_cs.get(i));
                startActivity(intent);
            }
        });
        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                data_cs.remove(i);
                adapterCaSi.notifyDataSetChanged();
                return false;
            }
        });


        btnThem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachCaSi.this, ThemCaSi.class);
                startActivity(intent);

            }

        });
    }

    private void khoitao() {
        data_cs.add(new CaSi("cs1", "SonTung", "24/11/2004", "Việt Nam", "Nhạc trẻ", "Nam"));
        data_cs.add(new CaSi("cs2", "ChiThuan", "24/11/2004", "Việt Nam", "Nhạc Bé", "Nam"));
        data_cs.add(new CaSi("cs3", "Mono", "24/11/2004", "Việt Nam", "Nhạc Xưa", "Nam"));
        data_cs.add(new CaSi("cs4", "HuongGiang", "24/11/2004", "Việt Nam", "Nhạc trẻ", "Nữ"));

    }

    private void setControll() {
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