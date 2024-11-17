package com.example.th2_sukien;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Bai11 extends Activity {
    //    /// Bài 11 ////

    private TextView textView;
    private ListView listView;
    private String[] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_bai11);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        // Đọc giá trị từ string-array
        values = getResources().getStringArray(R.array.my_string_array);

        // Thiết lập ArrayAdapter cho ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);

        // Thiết lập sự kiện click cho ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = values[position];
                textView.setText("Vị trí: " + position + ", Giá trị: " + selectedValue);
            }
        });
    }
}
