package com.example.fashionshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;

import java.util.*;
import java.util.stream.Collectors;

public class CategoriesFragment extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewCategories);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Product> allProducts = ProductRepository.getInstance().getAllProducts();
        List<CategoryWithProducts> categories = groupProductsByCategory(allProducts);

        CategoryAdapter adapter = new CategoryAdapter(categories, product -> {
            Intent intent = new Intent(getContext(), ProductDetailActivity.class);
            intent.putExtra("name", product.getName());
            intent.putExtra("brand", product.getBrand());
            intent.putExtra("category", product.getCategory());
            intent.putExtra("price", product.getPrice());
            intent.putExtra("description", product.getDescription());
            intent.putExtra("image", product.getImageUrl());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<CategoryWithProducts> groupProductsByCategory(List<Product> products) {
        Map<String, List<Product>> categoryMap = new LinkedHashMap<>();
        for (Product product : products) {
            if (!categoryMap.containsKey(product.getCategory())) {
                categoryMap.put(product.getCategory(), new ArrayList<>());
            }
            categoryMap.get(product.getCategory()).add(product);
        }

        List<CategoryWithProducts> categoryList = new ArrayList<>();
        for (Map.Entry<String, List<Product>> entry : categoryMap.entrySet()) {
            categoryList.add(new CategoryWithProducts(entry.getKey(), entry.getValue()));
        }

        return categoryList;
    }
}
