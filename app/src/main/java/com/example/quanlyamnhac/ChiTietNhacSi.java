package com.example.quanlyamnhac;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ChiTietNhacSi extends AppCompatActivity {

    TextView tvMaNS;
    EditText edtTenNS, edtNamSinh, edtGioiTinh;
    Button btnSua, btnXoa, btnQuayLai;
    ImageView ivHinh;
    Spinner spLoaiSP;

    List<String> data_lns = new ArrayList<>();
    ArrayAdapter adapter_lns;

    ListView lvDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_nhac_si);
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


        NhacSi ns = (NhacSi) getIntent().getSerializableExtra("item");
        tvMaNS.setText(ns.getMaNS());
        edtTenNS.setText(ns.getTenNS());
        edtNamSinh.setText(ns.getNamSinh());
        edtGioiTinh.setText(ns.getGioiTinh());

        if(ns.getTheLoai().equals("NT1")) {
            spLoaiSP.setSelection(0);
        }
        if(ns.getTheLoai().equals("NT2")) {
            spLoaiSP.setSelection(1);
        }
        if(ns.getTheLoai().equals("NT3")) {
            spLoaiSP.setSelection(2);
        }


        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(NhacSi item: DanhSachNhacSi.data_ns) {
                    if(item.getMaNS().equals(ns.maNS)) {
                        item.setTenNS(edtTenNS.getText().toString());
                        item.setNamSinh(edtNamSinh.getText().toString());
                        item.setGioiTinh(edtGioiTinh.getText().toString());

                        item.setTheLoai(spLoaiSP.getSelectedItem().toString());
                        Toast.makeText(ChiTietNhacSi.this,"Sửa thành công",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                DanhSachNhacSi.adapterNhacSi.notifyDataSetChanged();
                onBackPressed();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(NhacSi item: DanhSachNhacSi.data_ns) {
                    if(item.getMaNS().equals(ns.maNS)) {
                        DanhSachNhacSi.data_ns.remove(item);
                        Toast.makeText(ChiTietNhacSi.this,"Xóa thành công",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                DanhSachNhacSi.adapterNhacSi.notifyDataSetChanged();
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
        tvMaNS = findViewById(R.id.tvMaNS);
        edtTenNS = findViewById(R.id.edtTenSP);
        edtNamSinh = findViewById(R.id.edtNamSinh);
        edtGioiTinh = findViewById(R.id.edtGioiTinh);

        spLoaiSP = findViewById(R.id.spLoaiSP);
        ivHinh = findViewById(R.id.ivHinh);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }

}