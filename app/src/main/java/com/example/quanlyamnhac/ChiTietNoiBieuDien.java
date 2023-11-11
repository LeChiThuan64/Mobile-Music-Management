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

public class ChiTietNoiBieuDien extends AppCompatActivity {

    TextView tvMaBD;
    EditText edtTenCSBD, edtGioGiat;
    Button btnSua, btnXoa, btnQuayLai;
    ImageView ivHinh;
    Spinner spLoaiNoiBieuDien;

    List<String> data_lsp = new ArrayList<>();
    ArrayAdapter adapter_lsp;

    ListView lvDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_noibieudien);
        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        adapter_lsp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lsp);
        spLoaiNoiBieuDien.setAdapter(adapter_lsp);
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


        NoiBieuDien noiBieuDien = (NoiBieuDien) getIntent().getSerializableExtra("item");
        tvMaBD.setText(noiBieuDien.getMaBD());
        edtTenCSBD.setText(noiBieuDien.getTenCSBD());
        edtGioGiat.setText(noiBieuDien.getGioGiat());
        if(noiBieuDien.getLoaiNoiBieuDien().equals("Hà Nội")) {
            spLoaiNoiBieuDien.setSelection(0);
        }
        if(noiBieuDien.getLoaiNoiBieuDien().equals("Đà Nẳng")) {
            spLoaiNoiBieuDien.setSelection(1);
        }
        if(noiBieuDien.getLoaiNoiBieuDien().equals("TP.Hồ Chí Minh")) {
            spLoaiNoiBieuDien.setSelection(2);
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
                for(NoiBieuDien item: DanhSachNoiBieuDien.data_nbs) {
                    if(item.getMaBD().equals(noiBieuDien.maBD)) {
                        item.setTenCSBD(edtTenCSBD.getText().toString());
                        item.setGioGiat(edtGioGiat.getText().toString());
                        item.setLoaiNoiBieuDien(spLoaiNoiBieuDien.getSelectedItem().toString());
                        Toast.makeText(ChiTietNoiBieuDien.this,"Sửa thành công",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                DanhSachNoiBieuDien.adapterNoiBieuDien.notifyDataSetChanged();
                onBackPressed();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(NoiBieuDien item: DanhSachNoiBieuDien.data_nbs) {
                    if(item.getMaBD().equals(noiBieuDien.maBD)) {
                        DanhSachNoiBieuDien.data_nbs.remove(item);
                        Toast.makeText(ChiTietNoiBieuDien.this,"Xóa thành công",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                DanhSachNoiBieuDien.adapterNoiBieuDien.notifyDataSetChanged();
                onBackPressed();
            }
        });


    }

    private void KhoiTao() {
        data_lsp.add("Hà Nội");
        data_lsp.add("Đà Nẳng");
        data_lsp.add("TP.Hồ Chí Minh");
    }

    private void setControl() {
        tvMaBD = findViewById(R.id.tvMaBD);
        edtTenCSBD = findViewById(R.id.edtCasiBD);
        edtGioGiat = findViewById(R.id.edtGioGiat);
        spLoaiNoiBieuDien = findViewById(R.id.spLoaiNoiBieuDien);
        ivHinh = findViewById(R.id.ivHinh);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }


}