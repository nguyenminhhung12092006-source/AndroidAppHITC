package com.example.hitcapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ImageView imageView = findViewById(R.id.imageViewPayment);
        TextView textViewName = findViewById(R.id.textViewPaymentProductName);
        TextView textViewPrice = findViewById(R.id.textViewPaymentProductPrice);
        
        TextView textViewSubtotal = findViewById(R.id.textViewSubtotal);
        TextView textViewTotalAmount = findViewById(R.id.textViewTotalAmount);
        TextView textViewTotalBottom = findViewById(R.id.textViewTotalBottom);
        
        Button buttonConfirm = findViewById(R.id.buttonConfirmPayment);

        Product product = (Product) getIntent().getSerializableExtra("product");

        if (product != null) {
            // Sử dụng Glide để load ảnh từ URL thay vì resource ID
            Glide.with(this)
                    .load(product.getImageUrl())
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .into(imageView);
                    
            textViewName.setText(product.getName());
            textViewPrice.setText(product.getPrice());
            
            // Hiển thị tiền hàng
            textViewSubtotal.setText(product.getPrice());
            
            // Hiển thị tổng tiền
            textViewTotalAmount.setText(product.getPrice()); 
            textViewTotalBottom.setText(product.getPrice());
        }

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, "Đặt hàng thành công! Cảm ơn bạn.", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}