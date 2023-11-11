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

public class ThemBaiHat extends AppCompatActivity {
    EditText edtMaBH, edtTenBH, edtTheLoai, edtCaSiBD, edtNSST;
    Button btnThem, btnLamMoi, btnQuayLai;
    ImageView ivHinh;
    Spinner spLoaiSP;

    List<String> data_lbh = new ArrayList<>();
    ArrayAdapter adapter_lbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_bai_hat);
        setControl();
        setEvent();
    }
    private void setEvent() {
        KhoiTao();
        adapter_lbh = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lbh);
        spLoaiSP.setAdapter(adapter_lbh);
        spLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spLoaiSP.getSelectedItem().equals("NT1")) {
                    ivHinh.setImageResource(R.drawable.bh1);
                }
                if(spLoaiSP.getSelectedItem().equals("NT2")) {
                    ivHinh.setImageResource(R.drawable.bh2);
                }
                if(spLoaiSP.getSelectedItem().equals("NT3")) {
                    ivHinh.setImageResource(R.drawable.bh3);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaiHat bh = new BaiHat();
                bh.setMaBH(edtMaBH.getText().toString());
                bh.setTenBH(edtTenBH.getText().toString());
                bh.setTheLoai(edtTheLoai.getText().toString());
                bh.setCaSi(edtCaSiBD.getText().toString());
                bh.setnSST(edtNSST.getText().toString());
                bh.setLoaiNhac(spLoaiSP.getSelectedItem().toString());
                Toast.makeText(ThemBaiHat.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                DanhSachBaiHat.data_bh.add(bh);
                DanhSachBaiHat.adapterBaiHat.notifyDataSetChanged();
            }
        });
        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtMaBH.setText("");
                edtTenBH.setText("");
                edtTheLoai.setText("");
                edtCaSiBD.setText("");
                edtNSST.setText("");
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
        data_lbh.add("NT1");
        data_lbh.add("NT2");
        data_lbh.add("NT3");
    }
    private void setControl() {
        edtMaBH = findViewById(R.id.edtMaBH);
        edtTenBH = findViewById(R.id.edtTenBH);
        edtTheLoai = findViewById(R.id.edtTheLoai);
        edtCaSiBD = findViewById(R.id.edtCaSiBD);
        edtNSST = findViewById(R.id.edtNSST);
        spLoaiSP = findViewById(R.id.spLoaiSP);
        ivHinh = findViewById(R.id.ivHinh);
        btnThem = findViewById(R.id.btnThem);
        btnLamMoi = findViewById(R.id.btnLamMoi);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }
}