package com.example.hitcapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<Product> cartItems;
    private OnCartChangeListener listener;

    public interface OnCartChangeListener {
        void onCartChanged();
    }

    public CartAdapter(List<Product> cartItems, OnCartChangeListener listener) {
        this.cartItems = cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Product product = cartItems.get(position);
        
        // Dùng Glide để load ảnh từ URL giống như trong ProductAdapter
        Glide.with(holder.itemView.getContext())
                .load(product.getImageUrl())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(holder.imageView);

        holder.textViewName.setText(product.getName());
        holder.textViewPrice.setText(product.getPrice());

        holder.buttonRemove.setOnClickListener(v -> {
            cartItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());
            if (listener != null) listener.onCartChanged();
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName, textViewPrice;
        ImageButton buttonRemove;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewCartItem);
            textViewName = itemView.findViewById(R.id.textViewCartItemName);
            textViewPrice = itemView.findViewById(R.id.textViewCartItemPrice);
            buttonRemove = itemView.findViewById(R.id.buttonRemoveFromCart);
        }
    }
}