package com.example.hitcapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        productList = new ArrayList<>();
        // Thêm dữ liệu mẫu
        productList.add(new Product("Car Toy Yellow", "$15.00", R.mipmap.ic_launcher));
        productList.add(new Product("Blue Racing Car", "$25.00", R.mipmap.ic_launcher));
        productList.add(new Product("Classic Red Car", "$30.00", R.mipmap.ic_launcher));
        productList.add(new Product("Black Sport Car", "$45.00", R.mipmap.ic_launcher));
        productList.add(new Product("Truck Model", "$20.00", R.mipmap.ic_launcher));
        productList.add(new Product("Police Car", "$18.00", R.mipmap.ic_launcher));

        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);
    }
}