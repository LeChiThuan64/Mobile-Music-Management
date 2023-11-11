package com.example.quanlyamnhac;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ThemNhacSi extends AppCompatActivity {
    EditText edtMaNS, edtTenNS, edtNamSinh, edtGioiTinh;
    Button btnThem, btnLamMoi, btnQuayLai;
    ImageView ivHinh;
    Spinner spLoaiSP;

    List<String> data_lns = new ArrayList<>();
    ArrayAdapter adapter_lns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhac_si);
        setControl();
        setEvent();
    }
    private void setEvent() {
        KhoiTao();
        adapter_lns = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lns);
        spLoaiSP.setAdapter(adapter_lns);
        spLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spLoaiSP.getSelectedItem().equals("NT1")) {
                    ivHinh.setImageResource(R.drawable.ns1);
                }
                if(spLoaiSP.getSelectedItem().equals("NT2")) {
                    ivHinh.setImageResource(R.drawable.ns2);
                }
                if(spLoaiSP.getSelectedItem().equals("NT3")) {
                    ivHinh.setImageResource(R.drawable.ns3);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhacSi nhacSi = new NhacSi();
                nhacSi.setMaNS(edtMaNS.getText().toString());
                nhacSi.setTenNS(edtTenNS.getText().toString());
                nhacSi.setNamSinh(edtNamSinh.getText().toString());
                nhacSi.setGioiTinh(edtGioiTinh.getText().toString());
                nhacSi.setTheLoai(spLoaiSP.getSelectedItem().toString());
                Toast.makeText(ThemNhacSi.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                DanhSachNhacSi.data_ns.add(nhacSi);
                DanhSachNhacSi.adapterNhacSi.notifyDataSetChanged();
            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtMaNS.setText("");
                edtTenNS.setText("");
                edtNamSinh.setText("");
                edtGioiTinh.setText("");
                spLoaiSP.setSelection(0);
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
        data_lns.add("NT1");
        data_lns.add("NT2");
        data_lns.add("NT3");
    }
    private void setControl() {
        edtMaNS = findViewById(R.id.edtMaNS);
        edtTenNS = findViewById(R.id.edtTenNS);
        edtNamSinh = findViewById(R.id.edtNamSinh);
        edtGioiTinh = findViewById(R.id.edtGioitinh);
        spLoaiSP = findViewById(R.id.spLoaiSP);
        ivHinh = findViewById(R.id.ivHinh);
        btnThem = findViewById(R.id.btnThem);
        btnLamMoi = findViewById(R.id.btnLamMoi);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }
}