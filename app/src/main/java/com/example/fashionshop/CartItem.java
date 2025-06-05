package com.example.fashionshop;

public class CartItem {
    private Product product;
    private int quantity;
    private String size; // ⬅️ Добавляем поле размера

    public CartItem(Product product, String size) {
        this.product = product;
        this.size = size;
        this.quantity = 1;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
