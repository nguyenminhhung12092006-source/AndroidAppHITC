package com.example.hitcapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.textViewName.setText(product.getName());
        holder.textViewPrice.setText(product.getPrice());
        
        // Dùng Glide để load ảnh từ URL API
        Glide.with(holder.itemView.getContext())
                .load(product.getImageUrl())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(holder.imageView);

        // Click vào toàn bộ item để xem chi tiết
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductDetailActivity.class);
                intent.putExtra("product", product);
                v.getContext().startActivity(intent);
            }
        });

        // Click vào nút "Thêm vào giỏ"
        holder.buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartManager.addToCart(product);
                Toast.makeText(v.getContext(), "Đã thêm " + product.getName() + " vào giỏ hàng!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName, textViewPrice;
        ImageButton buttonAddToCart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewProduct);
            textViewName = itemView.findViewById(R.id.textViewProductName);
            textViewPrice = itemView.findViewById(R.id.textViewProductPrice);
            buttonAddToCart = itemView.findViewById(R.id.buttonAddToCart);
        }
    }
}