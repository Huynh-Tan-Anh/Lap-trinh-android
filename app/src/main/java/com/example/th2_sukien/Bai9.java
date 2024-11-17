package com.example.th2_sukien;

import static android.app.ProgressDialog.show;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Bai9 extends AppCompatActivity {
    private EditText etName, etCMND;
    private RadioGroup rgDegree;
    private CheckBox cbDocBao, cbDocSach, cbDocCoding;
    private Spinner spnJob;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai9_txtview_edittxt_btn_checkbox_btnrado);

        Button btnBackToList = findViewById(R.id.btnBackToList);
        btnBackToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng activity hiện tại và quay lại danh sách
            }
        });
        // Khởi tạo các View
        etName = findViewById(R.id.etName);
        etCMND = findViewById(R.id.etCMND);
        rgDegree = findViewById(R.id.rgDegree);
        cbDocBao = findViewById(R.id.cbDocBao);
        cbDocSach = findViewById(R.id.cbDocSach);
        cbDocCoding = findViewById(R.id.cbDocCoding);
        spnJob = findViewById(R.id.spnJob);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Xử lý sự kiện nhấn nút "Gửi thông tin"
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();

                // Lấy thông tin cá nhân
                result.append("Họ tên: ").append(etName.getText().toString()).append("\n");
                result.append("CMND: ").append(etCMND.getText().toString()).append("\n");

                // Lấy thông tin bằng cấp
                int selectedDegreeId = rgDegree.getCheckedRadioButtonId();
                if (selectedDegreeId != -1) {
                    RadioButton selectedDegree = findViewById(selectedDegreeId);
                    result.append("Bằng cấp: ").append(selectedDegree.getText().toString()).append("\n");
                }

                // Lấy thông tin sở thích
                StringBuilder hobbies = new StringBuilder();
                if (cbDocBao.isChecked()) hobbies.append("Đọc báo, ");
                if (cbDocSach.isChecked()) hobbies.append("Đọc sách, ");
                if (cbDocCoding.isChecked()) hobbies.append("Đọc coding");

                if (hobbies.length() == 0) {
                    Toast.makeText(Bai9.this, "Vui lòng chọn ít nhất một sở thích", Toast.LENGTH_SHORT).show();
                    return; // Dừng lại nếu không có sở thích nào được chọn
                }

                result.append("Sở thích: ").append(hobbies.toString()).append("\n");

                // Lấy thông tin nghề nghiệp
                result.append("Nghề nghiệp: ").append(spnJob.getSelectedItem().toString()).append("\n");
// Hiển thị thông tin bổ sung trong AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(Bai9.this);
                builder.setTitle("Thông tin cá nhân");
                builder.setMessage(result.toString());
                builder.setPositiveButton("Đóng", null);
                builder.show();
            }
        });
    }
}