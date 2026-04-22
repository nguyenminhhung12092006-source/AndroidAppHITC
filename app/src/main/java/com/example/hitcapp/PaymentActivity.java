package com.example.hitcapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ImageView imageView = findViewById(R.id.imageViewPayment);
        TextView textViewName = findViewById(R.id.textViewPaymentProductName);
        TextView textViewPrice = findViewById(R.id.textViewPaymentProductPrice);
        TextView textViewTotal = findViewById(R.id.textViewTotalAmount);
        Button buttonConfirm = findViewById(R.id.buttonConfirmPayment);

        Product product = (Product) getIntent().getSerializableExtra("product");

        if (product != null) {
            imageView.setImageResource(product.getImageResource());
            textViewName.setText(product.getName());
            textViewPrice.setText(product.getPrice());
            textViewTotal.setText(product.getPrice());
        }

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, getString(R.string.order_success), Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}