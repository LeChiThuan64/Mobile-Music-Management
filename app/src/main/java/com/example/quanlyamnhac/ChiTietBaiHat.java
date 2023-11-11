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

public class ChiTietBaiHat extends AppCompatActivity {

    TextView tvMaBH;
    EditText edtTenBH, edtTheLoai, edtCaSiBD, edtNSST;
    Button btnSua, btnXoa, btnQuayLai;
    ImageView ivHinh;
    Spinner spLoaiSP;

    List<String> data_lbh = new ArrayList<>();
    ArrayAdapter adapter_lbh;

    ListView lvDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_bai_hat);
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


        BaiHat bh = (BaiHat) getIntent().getSerializableExtra("item");
        tvMaBH.setText(bh.getMaBH());
        edtTenBH.setText(bh.getTenBH());
        edtTheLoai.setText(bh.getTheLoai());
        edtCaSiBD.setText(bh.getCaSi());
        edtNSST.setText(bh.getnSST());
        if(bh.getLoaiNhac().equals("NT1")) {
            spLoaiSP.setSelection(0);
        }
        if(bh.getLoaiNhac().equals("NT2")) {
            spLoaiSP.setSelection(1);
        }
        if(bh.getLoaiNhac().equals("NT3")) {
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
                for(BaiHat item: DanhSachBaiHat.data_bh) {
                    if(item.getMaBH().equals(bh.maBH)) {
                        item.setTenBH(edtTenBH.getText().toString());
                        item.setTheLoai(edtTheLoai.getText().toString());
                        item.setCaSi(edtCaSiBD.getText().toString());
                        item.setnSST(edtNSST.getText().toString());
                        item.setLoaiNhac(spLoaiSP.getSelectedItem().toString());
                        Toast.makeText(ChiTietBaiHat.this,"Sửa thành công",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                DanhSachBaiHat.adapterBaiHat.notifyDataSetChanged();
                onBackPressed();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(BaiHat item: DanhSachBaiHat.data_bh) {
                    if(item.getMaBH().equals(bh.maBH)) {
                        DanhSachBaiHat.data_bh.remove(item);
                        Toast.makeText(ChiTietBaiHat.this,"Xóa thành công",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                DanhSachBaiHat.adapterBaiHat.notifyDataSetChanged();
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
        tvMaBH = findViewById(R.id.tvMaBH);
        edtTenBH = findViewById(R.id.edtTenBH);
        edtTheLoai = findViewById(R.id.edtTheLoai);
        edtCaSiBD = findViewById(R.id.edtCaSiBD);
        edtNSST = findViewById(R.id.edtNSST);
        spLoaiSP = findViewById(R.id.spLoaiSP);
        ivHinh = findViewById(R.id.ivHinh);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }


}