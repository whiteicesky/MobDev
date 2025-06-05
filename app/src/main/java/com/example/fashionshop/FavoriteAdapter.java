package com.example.fashionshop;

import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private final List<Product> productList;
    private final OnRemoveClickListener removeClickListener;

    public interface OnRemoveClickListener {
        void onRemoveClick(Product product);
    }

    public FavoriteAdapter(List<Product> productList, OnRemoveClickListener removeClickListener) {
        this.productList = productList;
        this.removeClickListener = removeClickListener;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite, parent, false);
        return new FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.name.setText(product.getName());
        holder.brand.setText("Бренд: " + product.getBrand()); // ← добавили
        holder.price.setText(product.getPrice() + " ₽");
        Glide.with(holder.itemView.getContext()).load(product.getImageUrl()).into(holder.image);

        holder.btnRemove.setOnClickListener(v -> removeClickListener.onRemoveClick(product));
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class FavoriteViewHolder extends RecyclerView.ViewHolder {
        TextView name, brand, price;
        ImageView image;
        Button btnRemove;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewFavName);
            brand = itemView.findViewById(R.id.textViewFavBrand); // ← добавили
            price = itemView.findViewById(R.id.textViewFavPrice);
            image = itemView.findViewById(R.id.imageViewFav);
            btnRemove = itemView.findViewById(R.id.btnRemoveFavorite);
        }
    }

}
