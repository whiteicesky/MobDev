package com.example.fashionshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private final List<CategoryWithProducts> categories;
    private final ProductHorizontalAdapter.OnProductClickListener productClickListener;

    public CategoryAdapter(List<CategoryWithProducts> categories, ProductHorizontalAdapter.OnProductClickListener listener) {
        this.categories = categories;
        this.productClickListener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryWithProducts category = categories.get(position);
        holder.categoryTitle.setText(category.getTitle());

        ProductHorizontalAdapter productAdapter = new ProductHorizontalAdapter(category.getProducts(), productClickListener);
        holder.productsRecycler.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        holder.productsRecycler.setAdapter(productAdapter);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTitle;
        RecyclerView productsRecycler;

        CategoryViewHolder(View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.textViewCategoryTitle);
            productsRecycler = itemView.findViewById(R.id.recyclerViewProducts);
        }
    }
}
