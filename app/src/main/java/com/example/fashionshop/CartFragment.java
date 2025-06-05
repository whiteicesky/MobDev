package com.example.fashionshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;
import java.util.*;

public class CartFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView totalTextView, emptyTextView;
    private Button checkoutButton;
    private CartAdapter cartAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewCart);
        totalTextView = view.findViewById(R.id.textViewTotal);
        emptyTextView = view.findViewById(R.id.textViewEmpty);
        checkoutButton = view.findViewById(R.id.buttonCheckout);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<CartItem> cartItems = CartManager.getInstance().getCartItems();
        cartAdapter = new CartAdapter(cartItems, this::updateTotal);
        recyclerView.setAdapter(cartAdapter);

        updateTotal();

        checkoutButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Оформление заказа...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getContext(), CheckoutActivity.class);
            startActivity(intent);
        });

        return view;
    }

    private void updateTotal() {
        int total = CartManager.getInstance().getTotalPrice();
        totalTextView.setText("Итого: " + total + " ₽");

        boolean isEmpty = cartAdapter.getItemCount() == 0;
        emptyTextView.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
        totalTextView.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
        checkoutButton.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        cartAdapter.notifyDataSetChanged(); // Обновим список при возвращении на экран
        updateTotal(); // Пересчёт суммы
    }
}