package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;
    private ImageButton buttonCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewProducts);
        buttonCart = findViewById(R.id.buttonCart);
        
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        productList = new ArrayList<>();
        // Cập nhật dữ liệu với các ảnh bạn đã thêm vào drawable
        productList.add(new Product(getString(R.string.product_iphone_15_pro_name), getString(R.string.product_iphone_15_pro_price), R.drawable.img));
        productList.add(new Product(getString(R.string.product_samsung_s24_name), getString(R.string.product_samsung_s24_price), R.drawable.img_1));
        productList.add(new Product(getString(R.string.product_pixel_8_name), getString(R.string.product_pixel_8_price), R.drawable.img_2));
        productList.add(new Product(getString(R.string.product_xiaomi_14_name), getString(R.string.product_xiaomi_14_price), R.drawable.img_3));
        productList.add(new Product(getString(R.string.product_oppo_find_x7_name), getString(R.string.product_oppo_find_x7_price), R.drawable.img_4));
        productList.add(new Product(getString(R.string.product_vivo_x100_name), getString(R.string.product_vivo_x100_price), R.drawable.img_5));

        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);

        // Mở màn hình Giỏ hàng
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}