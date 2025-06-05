package com.example.fashionshop;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;
import java.util.*;

public class FavoritesFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView emptyTextView;
    private ProductAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewFavorites);
        emptyTextView = view.findViewById(R.id.textViewEmptyFavorites);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        List<Product> favorites = FavoritesManager.getInstance().getFavorites();
        adapter = new ProductAdapter(favorites);
        recyclerView.setAdapter(adapter);

        updateUI();

        return view;
    }

    private void updateUI() {
        boolean isEmpty = adapter.getItemCount() == 0;
        emptyTextView.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
    }
}