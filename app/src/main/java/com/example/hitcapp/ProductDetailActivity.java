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

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView imageView = findViewById(R.id.imageViewDetail);
        TextView textViewName = findViewById(R.id.textViewNameDetail);
        TextView textViewPrice = findViewById(R.id.textViewPriceDetail);
        ImageButton buttonAddToCart = findViewById(R.id.buttonAddToCartDetail); // Đã sửa từ Button thành ImageButton
        Button buttonBuyNow = findViewById(R.id.buttonBuyNowDetail);
        ImageButton buttonBack = findViewById(R.id.buttonBack);

        Product product = (Product) getIntent().getSerializableExtra("product");

        if (product != null) {
            imageView.setImageResource(product.getImageResource());
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