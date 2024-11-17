package com.example.th2_sukien;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Bai12 extends Activity {
    //     //////Bài 12 ListView Nhập /////
    private TextView textView;
    private ListView listView;
    private String[] values;
    private EditText editTextName;
    private ArrayList<String> nameList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        textView = findViewById(R.id.textView);
        editTextName = findViewById(R.id.editTextName);
        listView = findViewById(R.id.listView);
        Button buttonAdd = findViewById(R.id.buttonAdd);

        // Khởi tạo ArrayList và ArrayAdapter
        nameList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameList);
        listView.setAdapter(adapter);

        // Thiết lập sự kiện click cho nút Nhập
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                if (!name.isEmpty()) {
                    // Thêm tên vào ArrayList và cập nhật ListView
                    nameList.add(name);
                    adapter.notifyDataSetChanged(); // Cập nhật ListView
                    editTextName.setText(""); // Xóa nội dung EditText
                }
            }
        });

        // Thiết lập sự kiện click cho ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = nameList.get(position);
                textView.setText("Vị trí: " + position + ", Giá trị: " + selectedValue);
                textView.setTextColor(getResources().getColor(R.color.blue)); // Đổi màu chữ sang xanh dương
            }
        });
    }
}
