package com.example.projectandroidx.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.projectandroidx.R;
import com.example.projectandroidx.databinding.FragmentCartBinding;
import com.example.projectandroidx.ui.detail.DetailFragment;


public class CartFragment extends Fragment {

    private FragmentCartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CartViewModel galleryViewModel =
                new ViewModelProvider(this).get(CartViewModel.class);

        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.cartHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CartFragment.this)
                        .navigate(R.id.action_nav_cart_to_nav_home);
            }
        });

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // xu ly nut thanh toan trong cart
//        binding.cartPayment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(CartFragment.this)
//                        .navigate(R.id.);
//            }
//        });


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}