package com.example.quanlyamnhac;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DanhSach extends AppCompatActivity {
Button btnDSBaiHat,btnDSCaSi,btnDSNgheSI,btnDSNoiBieuDien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);
        setConTrol();
        setEven();
    }

    private void setEven() {
         btnDSCaSi.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(DanhSach.this, DanhSachCaSi.class);
                 startActivity(intent);
                 Toast.makeText(DanhSach.this, " Mời Bạn Vô Danh Sách Ca Sĩ !", Toast.LENGTH_LONG).show();
             }
         });
         btnDSNoiBieuDien.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(DanhSach.this, DanhSachNoiBieuDien.class);
                 startActivity(intent);
                 Toast.makeText(DanhSach.this, " Mời Bạn Vô Danh Nơi Biểu Diễn  !", Toast.LENGTH_LONG).show();
             }
         });
        btnDSBaiHat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSach.this, DanhSachBaiHat.class);
                startActivity(intent);
                Toast.makeText(DanhSach.this, " Mời Bạn Vô Danh Nơi Biểu Diễn  !", Toast.LENGTH_LONG).show();
            }
        });
        btnDSNgheSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSach.this, DanhSachNhacSi.class);
                startActivity(intent);
                Toast.makeText(DanhSach.this, " Mời Bạn Vô Danh Nơi Biểu Diễn  !", Toast.LENGTH_LONG).show();
            }
        });
    }



    // Thanh menu
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
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setConTrol() {
        btnDSBaiHat=findViewById(R.id.btnDSBaiHat);
        btnDSCaSi=findViewById(R.id.btnDSCaSi);
        btnDSNgheSI=findViewById(R.id.btnDSNgheSi);
        btnDSNoiBieuDien=findViewById(R.id.btnDSNoiBieuDien);
    }
}