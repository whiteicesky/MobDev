package com.example.fashionshop;

import android.os.Bundle;
import android.view.*;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;
import com.example.fashionshop.R;
import com.example.fashionshop.ProductAdapter;
import com.example.fashionshop.Product;
import com.google.firebase.database.*;
import java.util.*;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewHome);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        productList = new ArrayList<>();
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);

        loadProducts();

        return view;
    }

    private void loadProducts() {
        productList.clear();

        productList.add(new Product(
                "Хлопковое худи",
                "Balenciaga",
                "Мужская одежда",
                165000,
                getResources().getString(R.string.balenc1),
                "https://st-cdn.tsum.com/sig/8c474cc845df607e4bad6db35ea4aded/width/237/i/c2/f3/7f/95/e6d6661d-769a-49ae-9c21-e7283bfb9a6a.jpg"
        ));

        productList.add(new Product(
                "Футболка хлопковая",
                "Vetements",
                "Мужская одежда",
                69700,getResources().getString(R.string.vetement2),
                "https://st-cdn.tsum.com/sig/1a4d9e3ad8a8e3ecaf47da5a235a1902/width/237/i/18/a3/d3/6c/42ebd964-fdac-41c8-9133-283785fa0ab4.jpg"
        ));

        productList.add(new Product(
                "Кожанные кеды Hollywood Jumbolace",
                "Rick Owens",
                "Унисекс обувь",
                99500,getResources().getString(R.string.rick1),
                "https://st-cdn.tsum.com/sig/964e722af5c4870d21721c065251a534/width/763/i/61/33/7d/ea/86776c69-2f10-4e6a-94ec-1580234803f6.jpg"
        ));

        productList.add(new Product(
                "Кожанные кеды Hollywood",
                "Rick Owens",
                "Унисекс обувь",
                94150,getResources().getString(R.string.rick2),
                "https://st-cdn.tsum.com/sig/9c6aba43667e00e00a5427234f9f54ed/width/237/i/1d/29/45/33/bb2c1e1f-c817-4be6-9d0f-fa8e3519136b.jpg"
        ));

        productList.add(new Product(
                "Майка хлопковая",
                "Vetements",
                "Женская одежда",
                38950,getResources().getString(R.string.vetement1),
                "https://st-cdn.tsum.com/sig/c8c571406858bcd48c92523429de42d4/width/237/i/00/ce/89/24/8191568a-3a13-445a-96d4-4eef9c18e50d.jpg"
        ));

        productList.add(new Product(
                "Хлопковая толстовка",
                "Balenciaga",
                "Мужская одежда",
                173999,getResources().getString(R.string.balenc2),
                "https://st-cdn.tsum.com/sig/bde4de967b7385ddc805469f15d1895d/width/237/i/6a/34/8a/de/1c856ce2-ce09-4221-8be2-15c8d4c74fac.jpg"
        ));

        adapter.notifyDataSetChanged();
    }

}
