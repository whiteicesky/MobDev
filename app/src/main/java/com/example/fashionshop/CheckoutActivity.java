package com.example.fashionshop;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    private EditText nameInput, addressInput, phoneInput;
    private TextView totalPriceText;
    private Button confirmOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        nameInput = findViewById(R.id.editTextName);
        addressInput = findViewById(R.id.editTextAddress);
        phoneInput = findViewById(R.id.editTextPhone);
        totalPriceText = findViewById(R.id.textViewTotalPrice);
        confirmOrderButton = findViewById(R.id.buttonConfirmOrder);
        
        List<CartItem> cartItems = CartManager.getInstance().getCartItems();
        int totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity(); // если есть количество
            Product p = item.getProduct();
            p.getName();
            p.getBrand();
        }
        totalPriceText.setText("Итого: " + totalPrice + " ₽");

        confirmOrderButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String address = addressInput.getText().toString().trim();
            String phone = phoneInput.getText().toString().trim();

            if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

            // Здесь можно реализовать отправку заказа (API, база данных и т.д.)
//            Toast.makeText(this, "Заказ оформлен!", Toast.LENGTH_LONG).show();
            new AlertDialog.Builder(this)
                    .setTitle("Заказ оформлен!")
                    .setMessage("Имя: " + name + "\nАдрес: " + address + "\nТелефон: " + phone)
                    .setPositiveButton("ОК", (dialog, which) -> {
                        CartManager.getInstance().clearCart();
                        finish(); // Закрыть экран только после нажатия "ОК"
                    })
                    .setCancelable(false) // Запретить закрытие по нажатию вне окна или кнопке "Назад"
                    .show();

        });
    }
}

