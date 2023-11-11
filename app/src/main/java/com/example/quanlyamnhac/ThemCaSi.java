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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ThemCaSi extends AppCompatActivity {
    EditText edMaCaSI, edtTenCaSi, edtNgaySinh, edtQuocTich;
    Spinner spLoaiAN;
    RadioButton rdNam, rdNu;
    ImageView ivHinh;
    Button btnThem, btnMhapLai, btnThoat;
    List<String> data_lcs = new ArrayList<>();

    ArrayAdapter adapter_lcs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_ca_si);
        setConTrol();
        setEvent();

    }

    private void setEvent() {
        setKhoiTao();
        adapter_lcs = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data_lcs);
        spLoaiAN.setAdapter(adapter_lcs);
        spLoaiAN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spLoaiAN.getSelectedItem().equals("Nhạc trẻ"))
                    ivHinh.setImageResource(R.drawable.nhactre);
                if (spLoaiAN.getSelectedItem().equals("Nhạc Bé"))
                    ivHinh.setImageResource(R.drawable.nhacbe);
                if (spLoaiAN.getSelectedItem().equals("Nhạc Xưa"))
                    ivHinh.setImageResource(R.drawable.nhacxua);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaSi caSi = new CaSi();
                caSi.setMaCS(edMaCaSI.getText().toString());
                caSi.setTenCS(edtTenCaSi.getText().toString());
                caSi.setNgaySinh(edtNgaySinh.getText().toString());
                caSi.setQuocTich(edtQuocTich.getText().toString());
                caSi.setTheLoai(spLoaiAN.getSelectedItem().toString());
                caSi.setGioiTinh(rdNam.isChecked() ? "Nam" : "Nu");
                DanhSachCaSi.data_cs.add(caSi);
                DanhSachCaSi.adapterCaSi.notifyDataSetChanged();
                Toast.makeText(ThemCaSi.this, "Bạn Đã Thêm Thành Công ", Toast.LENGTH_LONG).show();
            }
        });


        btnMhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edMaCaSI.setText("");
                edtTenCaSi.setText("");
                edtNgaySinh.setText("");
                edtQuocTich.setText("");
                spLoaiAN.setSelection(0);
                edMaCaSI.requestFocus();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
     /*   btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogExit();
            }
        });*/

    }



   /* private void DialogExit() {
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialogexit);

        dialog.setCanceledOnTouchOutside(false);

        Button btnCo = dialog.findViewById(R.id.btnCo);
        Button btnKhong = dialog.findViewById(R.id.btnKhong);

        btnCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemCaSi.this,DanhSachCaSi.class);
                startActivity(intent);
            }
        });

        btnKhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }*/


    private void setKhoiTao() {
        data_lcs.add("Nhạc trẻ");
        data_lcs.add("Nhạc Bé");
        data_lcs.add("Nhạc Xưa");
    }

    private void setConTrol() {
        edMaCaSI = findViewById(R.id.edMaCaSI);
        edtTenCaSi = findViewById(R.id.edtTenCaSi);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);

        rdNam = findViewById(R.id.radNam);
        rdNu = findViewById(R.id.radNu);

        edtQuocTich = findViewById(R.id.edtQuocTich);

        btnThem = findViewById(R.id.btnThem);
        btnMhapLai = findViewById(R.id.btnNhapLai);
        btnThoat = findViewById(R.id.btnThoat);
        ivHinh = findViewById(R.id.ivHinh);
        spLoaiAN = findViewById(R.id.spLoaiNhac);
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