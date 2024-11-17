package com.example.th2_sukien;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Context mContext;
    private final List<String> mData;
    private final Map<Integer, Class<?>> activityMap;

    public MyListAdapter(Context context, List<String> data) {
        super(context, R.layout.list_item_layout, data);
        mContext = context;
        mData = data;

        // Khởi tạo và ánh xạ từ vị trí mục đến Activity tương ứng
        activityMap = new HashMap<>();
        activityMap.put(0, Bai1.class);
        activityMap.put(1, Bai2.class);
        activityMap.put(2, Bai3.class);
        activityMap.put(3, Bai4.class);
        activityMap.put(4, Bai7.class);
        activityMap.put(5, Bai8.class);
        activityMap.put(6, Bai9.class);
        activityMap.put(7, Bai11.class);
        activityMap.put(8, Bai12.class);
        activityMap.put(9, Bai14.class);
        activityMap.put(10, Bai15.class);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(mData.get(position));

        TextView subItem = convertView.findViewById(R.id.subItem);

        // Set dữ liệu subitem tương ứng với mỗi mục
        switch (position) {
                case 0:
                    subItem.setText("Toast và tùy chỉnh Toast trong Android");
                    break;
                case 1:
                    subItem.setText("Alert Dialog (Hộp thoại cảnh báo) trong Android");
                    break;
                case 2:
                    subItem.setText("Thực hành và hiểu được các kiểu lập trình sự kiện trong Android");
                    break;
                case 3:
                    subItem.setText("Thực hành và hiểu được các kiểu lập trình sự kiện trong Android");
                    break;
                case 4:
                    subItem.setText("Thực hành và hiểu được Alert Dialog");
                    break;
                case 5:
                    subItem.setText("TextView, EditText, Button");
                    break;
                case 6:
                    subItem.setText("TextView, EditText, Button, Checkbox, RadioButton");
                    break;
                case 7:
                    subItem.setText("ListView");
                    break;
                case 8:
                    subItem.setText("ListView");
                    break;
                case 9:
                    subItem.setText("Custom ListView, Cách kế thừa ArrayAdapter");
                    break;
                case 10:
                    subItem.setText("Spinner, Kết hợp Spinner, ListView");
                    break;
        }



        // Xử lý sự kiện click trên mỗi mục
        Button button = convertView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra xem vị trí của mục này có trong ánh xạ không
                if (activityMap.containsKey(position)) {
                    // Chuyển hướng đến Activity tương ứng
                    Intent intent = new Intent(mContext, activityMap.get(position));
                    mContext.startActivity(intent);
                }
            }
        });
        return convertView;
    }
}