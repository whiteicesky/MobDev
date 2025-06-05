package com.example.fashionshop;

import java.util.*;

public class FavoritesManager {
    private static FavoritesManager instance;
    private final List<Product> favorites = new ArrayList<>();

    private FavoritesManager() {}

    public static FavoritesManager getInstance() {
        if (instance == null) {
            instance = new FavoritesManager();
        }
        return instance;
    }

    public void addToFavorites(Product product) {
        if (!favorites.contains(product)) {
            favorites.add(product);
        }
    }

    public List<Product> getFavorites() {
        return favorites;
    }

    public void removeFromFavorites(Product product) {
        favorites.remove(product);
    }

    public void clearFavorites() {
        favorites.clear();
    }
}