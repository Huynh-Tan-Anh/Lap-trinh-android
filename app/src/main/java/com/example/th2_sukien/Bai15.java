package com.example.th2_sukien;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Bai15 extends Activity {

    Spinner spinnerCategories;
    ListView listViewProducts;

    // Dữ liệu cho Spinner (Danh mục sản phẩm)
    String[] categories = {"Điện Thoại", "Máy Tính", "Phụ Kiện"};

    // Dữ liệu cho ListView (Sản phẩm cho từng danh mục)
    String[][] products = {
            {"Iphone 5", "Samsung S III", "HTC", "Windows Phone Surface", "Nokia 1100", "Q-Mobile"},
            {"MacBook Pro", "Dell XPS", "HP Pavilion", "Asus ROG"},
            {"Tai Nghe", "Bàn Phím", "Chuột", "Loa"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai15_spinner);

        // Khởi tạo Spinner và ListView
        spinnerCategories = findViewById(R.id.spinner_categories);
        listViewProducts = findViewById(R.id.listView_products);

        // Tạo ArrayAdapter cho Spinner
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(categoryAdapter);

        // Thiết lập lắng nghe sự kiện khi chọn danh mục trong Spinner
        spinnerCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Khi chọn danh mục, cập nhật ListView với các sản phẩm tương ứng
                ArrayAdapter<String> productAdapter = new ArrayAdapter<>(Bai15.this,
                        android.R.layout.simple_list_item_1, products[position]);
                listViewProducts.setAdapter(productAdapter);

                // Thiết lập sự kiện khi chọn sản phẩm trong ListView để hiển thị Toast
                listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                        // Hiển thị thông báo Toast khi chọn sản phẩm
                        String selectedProduct = products[position][pos];
                        Toast.makeText(Bai15.this, "Sản phẩm: " + selectedProduct, Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không cần hành động gì khi không có mục nào được chọn
            }
        });

    }

}
