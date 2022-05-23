package com.example.projectandroidx.ui.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.projectandroidx.databinding.FragmentHomeBinding;
import com.example.projectandroidx.databinding.FragmentProductBinding;

public class ProductFragment extends Fragment {

    private FragmentProductBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProductViewModel productViewModel =
                new ViewModelProvider(this).get(ProductViewModel.class);

        binding = FragmentProductBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}