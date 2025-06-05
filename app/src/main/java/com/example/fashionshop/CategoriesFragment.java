package com.example.fashionshop;

import android.os.Bundle;
import android.view.*;

import androidx.fragment.app.Fragment;
import com.example.fashionshop.R;

public class CategoriesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }
}
