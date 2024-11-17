package com.example.th2_sukien;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class Bai7 extends Activity{
//  bài 7 alert_dialog
    private CheckBox checkBoxRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);

        checkBoxRemember = findViewById(R.id.checkBoxRemember);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        Button buttonExit = findViewById(R.id.buttonExit);

        // Listener cho CheckBox để hiển thị Toast khi check hoặc uncheck
        checkBoxRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(Bai7.this, "Bạn đã lưu thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Bai7.this, "Bạn không lưu thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Sự kiện nút đăng nhập
        buttonLogin.setOnClickListener(v -> login());

        // Sự kiện nút thoát
        buttonExit.setOnClickListener(v -> showExitDialog());
    }

    private void login() {
        // Code xử lý đăng nhập (thay thế logic đăng nhập thực tế ở đây)
        String username = "example"; // thay thế bằng logic đăng nhập thực tế
        String password = "example"; // thay thế bằng logic đăng nhập thực tế

        Toast.makeText(Bai7.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
    }

    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Bai7.this);
        builder.setTitle("Thoát ứng dụng");
        builder.setMessage("Bạn có chắc chắn muốn thoát ứng dụng?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            finish(); // Đóng ứng dụng
        });
        builder.setNegativeButton("No", (dialog, which) -> {
            // Không làm gì cả, chỉ đóng dialog
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
