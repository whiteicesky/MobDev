package com.example.fashionshop;

import android.content.*;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.*;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final List<Product> productList;
    private final boolean showButtons;

    public ProductAdapter(List<Product> productList) {
        this(productList, false);
    }

    public ProductAdapter(List<Product> productList, boolean showButtons) {
        this.productList = productList;
        this.showButtons = showButtons;
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
        Context context = holder.itemView.getContext();

        holder.productName.setText(product.getName());
        holder.brand.setText("Бренд: " + product.getBrand());
        holder.category.setText("Категория: " + product.getCategory());
        holder.price.setText(product.getPrice() + " ₽");

        Glide.with(context).load(product.getImageUrl()).into(holder.productImage);

        if (showButtons) {
            holder.addToCartBtn.setVisibility(View.VISIBLE);
            holder.addToFavBtn.setVisibility(View.VISIBLE);

            holder.addToCartBtn.setOnClickListener(v -> {
                CartManager.getInstance().addToCart(product);
                Toast.makeText(context, "Добавлено в корзину", Toast.LENGTH_SHORT).show();
            });

            holder.addToFavBtn.setOnClickListener(v -> {
                FavoritesManager.getInstance().addToFavorites(product);
                Toast.makeText(context, "Добавлено в избранное", Toast.LENGTH_SHORT).show();
            });
        } else {
            holder.addToCartBtn.setVisibility(View.GONE);
            holder.addToFavBtn.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("name", product.getName());
            intent.putExtra("brand", product.getBrand());
            intent.putExtra("category", product.getCategory());
            intent.putExtra("price", product.getPrice());
            intent.putExtra("description", product.getDescription());
            intent.putExtra("image", product.getImageUrl());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName, brand, category, price;
        ImageView productImage;
        Button addToCartBtn, addToFavBtn;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.textViewProductName);
            brand = itemView.findViewById(R.id.textViewBrand);
            category = itemView.findViewById(R.id.textViewCategory);
            price = itemView.findViewById(R.id.textViewPrice);
            productImage = itemView.findViewById(R.id.imageViewProduct);
            addToCartBtn = itemView.findViewById(R.id.buttonAddToCart);
            addToFavBtn = itemView.findViewById(R.id.buttonAddToFavorites);
        }
    }
}