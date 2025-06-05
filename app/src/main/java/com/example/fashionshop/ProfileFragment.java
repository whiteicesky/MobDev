package com.example.fashionshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;
import com.google.firebase.auth.*;

public class ProfileFragment extends Fragment {

    private TextView tvUserEmail;
    private Button btnLogin, btnRegister, btnLogout;
    private FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tvUserEmail = view.findViewById(R.id.tvUserEmail);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnRegister = view.findViewById(R.id.btnRegister);
        btnLogout = view.findViewById(R.id.btnLogout);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        if (user != null) {
            // Пользователь вошёл
            tvUserEmail.setText("Вы вошли как: " + user.getEmail());

            btnLogin.setVisibility(View.GONE);
            btnRegister.setVisibility(View.GONE);
            btnLogout.setVisibility(View.VISIBLE);
        } else {
            // Пользователь НЕ вошёл
            tvUserEmail.setText("Вы не вошли в аккаунт");

            btnLogin.setVisibility(View.VISIBLE);
            btnRegister.setVisibility(View.VISIBLE);
            btnLogout.setVisibility(View.GONE);
        }

        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), LoginActivity.class));
        });

        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), RegisterActivity.class));
        });

        btnLogout.setOnClickListener(v -> {
            auth.signOut();
            Toast.makeText(getContext(), "Выход выполнен", Toast.LENGTH_SHORT).show();
            // Обновим фрагмент (перезапуск)
            requireActivity().recreate();
        });

        return view;
    }
}
