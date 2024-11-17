package com.example.th2_sukien;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        List<String> items = Arrays.asList("Bài 1", "Bài 2", "Bài 3", "Bài 4", "Bài 7", "Bài 8", "Bài 9", "Bài 11", "Bài 12", "Bài 14", "Bài 15");
        MyListAdapter adapter = new MyListAdapter(this, items);
        listView.setAdapter(adapter);

//        // Khởi tạo các View
//        Button btnbai1 = findViewById(R.id.btnbai1);
//        Button btnbai2 = findViewById(R.id.btnbai2);
//        Button btnbai3 = findViewById(R.id.btnbai3);
//        Button btnbai4 = findViewById(R.id.btnbai4);
//        Button btnbai7 = findViewById(R.id.btnbai7);
//        Button btnbai8 = findViewById(R.id.btnbai8);
//        Button btnbai9 = findViewById(R.id.btnbai9);
//        Button btnbai11 = findViewById(R.id.btnbai11);
//        Button btnbai12 = findViewById(R.id.btnbai12);
//        Button btnbai14 = findViewById(R.id.btnbai14);
//        Button btnbai15 = findViewById(R.id.btnbai15);
//
//        // Xử lý sự kiện cho các nút
//        btnbai3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Bai3.class);
//                startActivity(intent);
//            }
//        });
//
//        btnbai4.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Bai4.class);
//                startActivity(intent);
//            }
//        });
//
//
//
//        btnbai7.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Bai7.class);
//                startActivity(intent);
//            }
//        });
//
//        btnbai8.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Bai8.class);
//                startActivity(intent);
//            }
//        });
//
//        btnbai9.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Bai9.class);
//                startActivity(intent);
//            }
//        });
//
//
//
//        btnbai11.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Bai11.class);
//                startActivity(intent);
//            }
//        });
//
//
//        btnbai12.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Bai12.class);
//                startActivity(intent);
//            }
//        });
//
//
//
//        btnbai14.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Bai14.class);
//                startActivity(intent);
//            }
//        });
//
//        btnbai15.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Bai15.class);
//                startActivity(intent);
//            }
//        });
    }
}