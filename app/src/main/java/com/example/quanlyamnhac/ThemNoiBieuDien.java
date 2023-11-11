package com.example.quanlyamnhac;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ThemNoiBieuDien extends AppCompatActivity {
    EditText edtMaBD, edtTenCaSiBieuDien, edtGioGiat;
    Button btnThem, btnLamMoi, btnQuayLai;
    ImageView ivHinh;
    Spinner spLoaiNoiBieuDien;

    List<String> data_lnbd = new ArrayList<>();
    ArrayAdapter adapter_lnbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_noibieudien);
        setControl();
        setEvent();
    }
    private void setEvent() {
        KhoiTao();
        adapter_lnbd = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lnbd);
        spLoaiNoiBieuDien.setAdapter(adapter_lnbd);
        spLoaiNoiBieuDien.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spLoaiNoiBieuDien.getSelectedItem().equals("Hà Nội")) {
                    ivHinh.setImageResource(R.drawable.hanoi);
                }
                if(spLoaiNoiBieuDien.getSelectedItem().equals("Đà Nẳng")) {
                    ivHinh.setImageResource(R.drawable.danang);
                }
                if(spLoaiNoiBieuDien.getSelectedItem().equals("TP.Hồ Chí Minh")) {
                    ivHinh.setImageResource(R.drawable.landmark81);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoiBieuDien noiBieuDien = new NoiBieuDien();
                noiBieuDien.setMaBD(edtMaBD.getText().toString());
                noiBieuDien.setTenCSBD(edtTenCaSiBieuDien.getText().toString());
                noiBieuDien.setGioGiat(edtGioGiat.getText().toString());
                noiBieuDien.setLoaiNoiBieuDien(spLoaiNoiBieuDien.getSelectedItem().toString());
                Toast.makeText(ThemNoiBieuDien.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                DanhSachNoiBieuDien.data_nbs.add(noiBieuDien);
                DanhSachNoiBieuDien.adapterNoiBieuDien.notifyDataSetChanged();
            }
        });

        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtMaBD.setText("");
                edtTenCaSiBieuDien.setText("");
                edtGioGiat.setText("");
                spLoaiNoiBieuDien.setSelection(0);
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void KhoiTao() {
        data_lnbd.add("Hà Nội");
        data_lnbd.add("Đà Nẳng");
        data_lnbd.add("TP.Hồ Chí Minh");
    }
    private void setControl() {
        edtMaBD = findViewById(R.id.edtMaBD);
        edtTenCaSiBieuDien = findViewById(R.id.edtTenCSBD);
        edtGioGiat = findViewById(R.id.edtGiaGiat);
        spLoaiNoiBieuDien = findViewById(R.id.spLoaiBiuDien);
        ivHinh = findViewById(R.id.ivHinh);
        btnThem = findViewById(R.id.btnThem);
        btnLamMoi = findViewById(R.id.btnLamMoi);
        btnQuayLai = findViewById(R.id.btnQuayLai);
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
            startActivity(intent);
        }
        if (item.getItemId() == R.id.DanhSach) {
            Intent intent = new Intent(this, DanhSach.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.Thoat) {
            Intent intent = new Intent(this, DanhSach.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}