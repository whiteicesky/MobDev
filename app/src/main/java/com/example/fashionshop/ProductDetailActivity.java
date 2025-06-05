package com.example.fashionshop;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tvName, tvBrand, tvCategory, tvPrice, tvDescription;
    private RadioGroup sizeGroup;
    private Button btnCart, btnFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        imageView = findViewById(R.id.detailImage);
        tvName = findViewById(R.id.detailName);
        tvBrand = findViewById(R.id.detailBrand);
        tvCategory = findViewById(R.id.detailCategory);
        tvPrice = findViewById(R.id.detailPrice);
        tvDescription = findViewById(R.id.detailDescription);
        sizeGroup = findViewById(R.id.sizeGroup);
        btnCart = findViewById(R.id.btnAddToCart);
        btnFavorite = findViewById(R.id.btnAddToFavorites);

        String name = getIntent().getStringExtra("name");
        String brand = getIntent().getStringExtra("brand");
        String category = getIntent().getStringExtra("category");
        int price = getIntent().getIntExtra("price", 0);
        String description = getIntent().getStringExtra("description");
        String imageUrl = getIntent().getStringExtra("image");

        tvName.setText(name);
        tvBrand.setText("Бренд: " + brand);
        tvCategory.setText("Категория: " + category);
        tvPrice.setText("Цена: " + price + " ₽");
        tvDescription.setText(description);
        Glide.with(this).load(imageUrl).into(imageView);

        // Устанавливаем размеры
        String[] sizes = category.toLowerCase().contains("обувь")
                ? new String[]{"40", "41", "42", "43"}
                : new String[]{"S", "M", "L", "XL"};

        for (String size : sizes) {
            RadioButton rb = new RadioButton(this);
            rb.setText(size);
            sizeGroup.addView(rb);
        }

        btnCart.setOnClickListener(v -> {
            int selectedId = sizeGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Выберите размер", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedSize = findViewById(selectedId);
                String size = selectedSize.getText().toString();
                Product product = new Product(name, brand, category, price, description, imageUrl);
                CartManager.getInstance().addToCart(product, size);
                Toast.makeText(this, "Добавлено в корзину: " + name + ", размер " + size, Toast.LENGTH_SHORT).show();
            }
        });

        btnFavorite.setOnClickListener(v -> {
                Product product = new Product(name, brand, category, price, description, imageUrl);
                FavoritesManager.getInstance().addToFavorites(product);
                Toast.makeText(this, "Добавлено в избранное ", Toast.LENGTH_SHORT).show();
        });
    }
}
