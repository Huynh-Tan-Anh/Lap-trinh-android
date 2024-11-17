package com.example.th2_sukien;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai3 extends AppCompatActivity {
    //Bai 3
    private EditText editTextA;
    private EditText editTextB;
    private TextView tvResult;

    EditText editTextCelsius;
    EditText editTextFahrenheit;

    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bai3);

        tvResult = findViewById(R.id.tvResult);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);


        Button btnSum = findViewById(R.id.btnSum);

        btnSum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                int result = a + b;
                tvResult.setText("Kết quả của phép cộng là: " + result);
            }
        });

        Button btnDifference = findViewById(R.id.btnDifference);
        btnDifference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                int result = a - b;
                tvResult.setText("Kết quả của phép trừ là: " + result);
            }
        });

        Button btnProduct = findViewById(R.id.btnProduct);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý phép nhân 2 số
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                int result = a * b;
                tvResult.setText("Kết quả của phép nhân là: " + result);
            }
        });

        Button btnDivide = findViewById(R.id.btnQuotient);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                if (b != 0) {
                    double result = (double) a / b;
                    tvResult.setText("Kết quả của phép chia là: " + result);
                } else {
                    tvResult.setText("Không thể chia cho 0");
                }
            }
        });

        Button btnGcd = findViewById(R.id.btnGCD);
        btnGcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                int result = findGCD(a, b);
                tvResult.setText("Ước số chung lớn nhất của " + a + " và " + b + " là: " + result);
            }
        });

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit(v);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bai3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void exit(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // Thiết lập tiêu đề của Dialog
        alertDialogBuilder.setTitle("Xác nhận để thoát..!!!");

        // Thiết lập biểu tượng cho Dialog
        alertDialogBuilder.setIcon(R.drawable.ic_launcher_foreground);

        // Thiết lập nội dung của Dialog
        alertDialogBuilder.setMessage("Bạn có muốn thoát?");

        alertDialogBuilder.setCancelable(false);

        // Thiết lập nút Đồng ý và xử lý sự kiện khi nút được nhấn
        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Đóng Activity hiện tại
                finish();
            }
        });

        // Thiết lập nút Không đồng ý và xử lý sự kiện khi nút được nhấn
        alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Bai3.this, "Bạn đã click vào nút không đồng ý", Toast.LENGTH_SHORT).show();
            }
        });

        // Thiết lập nút Hủy và xử lý sự kiện khi nút được nhấn
        alertDialogBuilder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Bạn đã click vào nút hủy", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    // Hàm tìm ước số chung lớn nhất
    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
