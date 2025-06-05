package com.example.fashionshop;

import java.util.*;

public class CartManager {
    private static CartManager instance;
    private final List<CartItem> cartItems = new ArrayList<>();

    private CartManager() {}

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(Product product, String size) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getName().equals(product.getName()) &&
                    item.getSize().equals(size)) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        cartItems.add(new CartItem(product, size));
    }

    public void removeFromCart(Product product) {
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().equals(product)) {
                iterator.remove();
                return;
            }
        }
    }

    public List<CartItem> getCartItems() {
//        return new ArrayList<>(cartItems); // возвращаем копию
        return cartItems;
    }

    public int getTotalPrice() {
        int total = 0;
        for (CartItem item : cartItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
    }
}
