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
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ChiTiecCaSi extends AppCompatActivity {

    TextView tvMaCS;
    EditText edtTenCaSi,edtNgaySinh,edtQuocTich;
    Spinner spLoaiAN;
    RadioButton rdNam , rdNu;
    ImageView ivHinh;
    Button btnSua,btnXoa,btnThoat;
    List<String> data_lcs= new ArrayList<>();

    ListView lvDanhSach;
    ArrayAdapter adapter_lcs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiec_ca_si);
        setConTrol();
        setEvent();

    }

    private void setEvent() {
        setKhoiTao();
        adapter_lcs= new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lcs);
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

        // hiện lên thông tin của Ca Sĩ Để Nhấp Vào
        CaSi caSi = (CaSi) getIntent().getSerializableExtra("caSi");
        tvMaCS.setText(caSi.getMaCS());
        edtTenCaSi.setText(caSi.getTenCS());
        edtNgaySinh.setText(caSi.getNgaySinh());
        edtQuocTich.setText(caSi.getQuocTich());

        if(caSi.getTheLoai().equals("Nhạc trẻ")) {
            spLoaiAN.setSelection(0);
        }if(caSi.getTheLoai().equals("Nhạc Bé")) {
            spLoaiAN.setSelection(1);
        }if(caSi.getTheLoai().equals("Nhạc Xưa")) {
            spLoaiAN.setSelection(2);
        }




        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(CaSi item : DanhSachCaSi.data_cs) {
                    if(item.getMaCS().equals(caSi.maCS)) {
                        item.setTenCS(edtTenCaSi.getText().toString());
                        item.setNgaySinh(edtNgaySinh.getText().toString());
                        item.setQuocTich(edtQuocTich.getText().toString());
                        item.setGioiTinh(rdNam.isChecked() ? "Nam" : "Nu");
                        item.setTheLoai(spLoaiAN.getSelectedItem().toString());
                        Toast.makeText(ChiTiecCaSi.this,"Sửa thành công",Toast.LENGTH_LONG).show();
                        break;
                    }
                }
                DanhSachCaSi.adapterCaSi.notifyDataSetChanged();
                onBackPressed();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (CaSi item : DanhSachCaSi.data_cs){
                    if (item.getMaCS().equals(caSi.maCS)){
                        DanhSachCaSi.data_cs.remove(item);
                        Toast.makeText(ChiTiecCaSi.this, "Xoa Thanh Cong", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                DanhSachCaSi.adapterCaSi.notifyDataSetChanged();
                onBackPressed();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
    private void setKhoiTao() {
        data_lcs.add("Nhạc trẻ");
        data_lcs.add("Nhạc Bé");
        data_lcs.add("Nhạc Xưa");
    }

    private void setConTrol() {
        tvMaCS = findViewById(R.id.tvMaCS);
        edtTenCaSi = findViewById(R.id.edtTenCaSi);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);

        rdNam = findViewById(R.id.radNam);
        rdNu = findViewById(R.id.radNu);

        edtQuocTich = findViewById(R.id.edtQuocTich);

        btnSua= findViewById(R.id.btnSua);
        btnXoa= findViewById(R.id.btnXoa);
        btnThoat= findViewById(R.id.btnThoat);
        ivHinh = findViewById(R.id.ivHinh);
        spLoaiAN = findViewById(R.id.spLoaiNhac);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.button_nav_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.home) {
            Intent intent = new Intent(this,TrangChu.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.DanhSach) {
            Intent intent = new Intent(this,DanhSach.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.Thoat) {
            Intent intent = new Intent(this,DanhSach.class);
            startActivity(intent);
            Toast.makeText(this, "Bạn Thoát", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}