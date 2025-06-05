package com.example.fashionshop;

import java.util.List;

public class CategoryWithProducts {
    private final String title;
    private final List<Product> products;

    public CategoryWithProducts(String title, List<Product> products) {
        this.title = title;
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public List<Product> getProducts() {
        return products;
    }
}

