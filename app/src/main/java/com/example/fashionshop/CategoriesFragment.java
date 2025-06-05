package com.example.fashionshop;

import android.os.Bundle;
import android.view.*;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fashionshop.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewCategories);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<CategoryWithProducts> categories = new ArrayList<>();
        categories.add(new CategoryWithProducts("Мужская одежда", getProductsByCategory("Мужская одежда")));
        categories.add(new CategoryWithProducts("Женская одежда", getProductsByCategory("Женская одежда")));
        categories.add(new CategoryWithProducts("Унисекс обувь", getProductsByCategory("Унисекс обувь")));

        CategoryAdapter adapter = new CategoryAdapter(categories);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Product> getProductsByCategory(String category) {
        // Предположим, есть какой-то список всех продуктов
        List<Product> allProducts = ProductRepository.getInstance().getAllProducts();
        List<Product> filtered = new ArrayList<>();
        for (Product p : allProducts) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                filtered.add(p);
            }
        }
        return filtered;
    }
}

