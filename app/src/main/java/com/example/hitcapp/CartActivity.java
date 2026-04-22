package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartActivity extends AppCompatActivity implements CartAdapter.OnCartChangeListener {

    private TextView textViewTotal;
    private List<Product> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewCart);
        textViewTotal = findViewById(R.id.textViewTotalCart);
        Button buttonCheckout = findViewById(R.id.buttonCheckoutFromCart);

        cartItems = CartManager.getCartItems();
        
        updateTotal();

        CartAdapter adapter = new CartAdapter(cartItems, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        buttonCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cartItems.isEmpty()) {
                    Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                    // Truyền sản phẩm đầu tiên đại diện hoặc xử lý giỏ hàng
                    intent.putExtra("product", cartItems.get(0)); 
                    startActivity(intent);
                } else {
                    Toast.makeText(CartActivity.this, getString(R.string.empty_cart), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateTotal() {
        textViewTotal.setText("Tổng cộng: " + cartItems.size() + " món");
    }

    @Override
    public void onCartChanged() {
        updateTotal();
    }
}