package com.example.th2_sukien;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai8 extends Activity {
    //////Bai 8
    private EditText edtDuongLich;
    private TextView tvAmLich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai8);

        // Liên kết với View
        edtDuongLich = findViewById(R.id.edtDuongLich);
        tvAmLich = findViewById(R.id.tvAmLich);
        Button btnChuyenDoi = findViewById(R.id.btnChuyenDoi);

        // Xử lý khi nhấn nút Chuyển đổi
        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String duongLichStr = edtDuongLich.getText().toString();
                if (duongLichStr.isEmpty()) {
                    Toast.makeText(Bai8.this, "Vui lòng nhập năm dương lịch", Toast.LENGTH_SHORT).show();
                    return;
                }

                int namDuongLich = Integer.parseInt(duongLichStr);

                // Kiểm tra điều kiện nhập
                if (namDuongLich < 1900) {
                    Toast.makeText(Bai8.this, "Năm dương lịch phải >= 1900", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chuyển đổi năm dương lịch sang năm âm lịch
                String namAmLich = convertToLunarYear(namDuongLich);
                tvAmLich.setText("Năm âm lịch: " + namAmLich);
            }
        });
    }

    // Hàm chuyển đổi năm dương lịch sang năm âm lịch
    private String convertToLunarYear(int year) {
        String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
        String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

        // Công thức tính can và chi
        String canChi = can[year % 10] + " " + chi[year % 12];
        return canChi;
    }
}
