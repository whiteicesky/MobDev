package com.example.fashionshop;

import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.*;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<CartItem> cartItems;
    private Runnable onCartUpdated;

    public CartAdapter(List<CartItem> cartItems, Runnable onCartUpdated) {
        this.cartItems = cartItems;
        this.onCartUpdated = onCartUpdated;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem item = cartItems.get(position);
        Product product = item.getProduct();

        holder.name.setText(product.getName());
        holder.quantity.setText(String.valueOf("Количество: "+item.getQuantity()));
        holder.price.setText(product.getPrice() + " ₽");
        Glide.with(holder.itemView.getContext()).load(product.getImageUrl()).into(holder.image);

//        holder.increaseBtn.setOnClickListener(v -> {
//            item.setQuantity(item.getQuantity() + 1);
//            notifyItemChanged(position);
//            onCartUpdated.run();
//        });
//
//        holder.decreaseBtn.setOnClickListener(v -> {
//            if (item.getQuantity() > 1) {
//                item.setQuantity(item.getQuantity() - 1);
//            } else {
//                cartItems.remove(position);
//                notifyItemRemoved(position);
//            }
//            notifyItemChanged(position);
//            onCartUpdated.run();
//        });

        holder.removeBtn.setOnClickListener(v -> {
            cartItems.remove(position);
            notifyItemRemoved(position);
            onCartUpdated.run();
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, price, quantity;
        Button increaseBtn, decreaseBtn, removeBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageViewCartProduct);
            name = itemView.findViewById(R.id.textViewCartProductName);
            price = itemView.findViewById(R.id.textViewCartPrice);
            quantity = itemView.findViewById(R.id.textViewCartQuantity);
//            increaseBtn = itemView.findViewById(R.id.buttonIncrease);
//            decreaseBtn = itemView.findViewById(R.id.buttonDecrease);
            removeBtn = itemView.findViewById(R.id.buttonRemove);
        }
    }
}
