package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView imageView = findViewById(R.id.imageViewDetail);
        TextView textViewName = findViewById(R.id.textViewNameDetail);
        TextView textViewPrice = findViewById(R.id.textViewPriceDetail);
        ImageButton buttonAddToCart = findViewById(R.id.buttonAddToCartDetail);
        Button buttonBuyNow = findViewById(R.id.buttonBuyNowDetail);
        ImageButton buttonBack = findViewById(R.id.buttonBack);

        Product product = (Product) getIntent().getSerializableExtra("product");

        if (product != null) {
            // Sử dụng Glide để load ảnh từ URL API
            Glide.with(this)
                    .load(product.getImageUrl())
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .into(imageView);
                    
            textViewName.setText(product.getName());
            textViewPrice.setText(product.getPrice());
        }

        // Nút Quay lại
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Nút Thêm vào giỏ hàng
        buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (product != null) {
                    CartManager.addToCart(product);
                    Toast.makeText(ProductDetailActivity.this, "Đã thêm " + product.getName() + " vào giỏ hàng!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Nút Mua ngay
        buttonBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (product != null) {
                    Intent intent = new Intent(ProductDetailActivity.this, PaymentActivity.class);
                    intent.putExtra("product", product);
                    startActivity(intent);
                }
            }
        });
    }
}