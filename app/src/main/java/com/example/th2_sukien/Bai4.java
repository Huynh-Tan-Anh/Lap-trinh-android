package com.example.th2_sukien;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Bai4 extends AppCompatActivity {

    private EditText editTextFahrenheit;
    private EditText editTextCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai4);

        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        editTextCelsius = findViewById(R.id.editTextCelsius);
        Button btnConvertToFahrenheit = findViewById(R.id.btnConvertToFahrenheit);
        Button btnConvertToCelsius = findViewById(R.id.btnConvertToCelsius);
        Button btnClear = findViewById(R.id.btnClear);

        btnConvertToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextCelsius.getText().toString().isEmpty()) {
                    double celsius = Double.parseDouble(editTextCelsius.getText().toString());
                    double fahrenheit = (celsius * 9/5) + 32;
                    editTextFahrenheit.setText(String.valueOf(fahrenheit));
                } else {
                    Toast.makeText(Bai4.this, "Please enter a temperature in Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnConvertToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextFahrenheit.getText().toString().isEmpty()) {
                    double fahrenheit = Double.parseDouble(editTextFahrenheit.getText().toString());
                    double celsius = (fahrenheit - 32) * 5/9;
                    editTextCelsius.setText(String.valueOf(celsius));
                } else {
                    Toast.makeText(Bai4.this, "Please enter a temperature in Fahrenheit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFahrenheit.setText("");
                editTextCelsius.setText("");
            }
        });
    }
}