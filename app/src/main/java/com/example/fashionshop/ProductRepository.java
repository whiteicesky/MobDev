package com.example.fashionshop;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static ProductRepository instance;
    private final List<Product> productList;

    private ProductRepository() {
        productList = new ArrayList<>();
        loadMockData(); // Можно заменить на загрузку из API/БД
    }

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    private void loadMockData() {
        productList.add(new Product("Футболка", "Nike", "Мужская одежда", 1500, "Удобная футболка", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Джинсы", "Levi's", "Мужская одежда", 3500, "Классические джинсы", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Платье", "Zara", "Женская одежда", 4000, "Летнее платье", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Юбка", "H&M", "Женская одежда", 2200, "Короткая юбка", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Кроссовки", "Adidas", "Унисекс обувь", 5000, "Спортивная обувь", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Ботинки", "Timberland", "Унисекс обувь", 8000, "Зимние ботинки", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Футболка", "Nike", "Мужская одежда", 1500, "Удобная футболка", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Джинсы", "Levi's", "Мужская одежда", 3500, "Классические джинсы", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Платье", "Zara", "Женская одежда", 4000, "Летнее платье", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Юбка", "H&M", "Женская одежда", 2200, "Короткая юбка", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Кроссовки", "Adidas", "Унисекс обувь", 5000, "Спортивная обувь", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Ботинки", "Timberland", "Унисекс обувь", 8000, "Зимние ботинки", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Футболка", "Nike", "Мужская одежда", 1500, "Удобная футболка", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Джинсы", "Levi's", "Мужская одежда", 3500, "Классические джинсы", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Платье", "Zara", "Женская одежда", 4000, "Летнее платье", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Юбка", "H&M", "Женская одежда", 2200, "Короткая юбка", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Кроссовки", "Adidas", "Унисекс обувь", 5000, "Спортивная обувь", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
        productList.add(new Product("Ботинки", "Timberland", "Унисекс обувь", 8000, "Зимние ботинки", "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"));
    }
}
