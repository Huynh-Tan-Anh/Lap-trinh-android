package com.example.th2_sukien;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Bai14 extends Activity {
        /////Bài 14 ()  /////
    private ListView listView;
    private TextView selectedItemTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customlistview);

        listView = findViewById(R.id.listView);
        selectedItemTextView = findViewById(R.id.selected_item_text);

        // Danh sách dữ liệu
        String[] items = {"One", "Two", "Three", "Four", "Five", "Long Text Example"};

        // Sử dụng CustomAdapter
        CustomAdapter adapter = new CustomAdapter(this, items);
        listView.setAdapter(adapter);

        // Bắt sự kiện click vào phần tử trong ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = items[position];
                selectedItemTextView.setText("Selected: " + selectedItem);
            }
        });


    }
    public class CustomAdapter extends ArrayAdapter<String> {

        private final Context context;
        private final String[] values;

        public CustomAdapter(Context context, String[] values) {
            super(context, R.layout.list_item, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item, parent, false);

            TextView textView = rowView.findViewById(R.id.item_text);
            ImageView imageView = rowView.findViewById(R.id.item_image);

            String text = values[position];
            textView.setText(text);

//            // Hiển thị hình ngôi sao nếu số ký tự <= 3, ngược lại hiển thị hình địa cầu
            if (text.length() <= 3) {
                imageView.setImageResource(R.drawable.img); // Thay star_icon bằng hình ảnh ngôi sao của bạn
            } else {
                imageView.setImageResource(R.drawable.earth); // Thay earth_icon bằng hình ảnh địa cầu của bạn
            }

            return rowView;
        }
    }
}
