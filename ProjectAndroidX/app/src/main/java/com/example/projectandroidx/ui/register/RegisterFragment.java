package com.example.projectandroidx.ui.register;

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
import com.example.projectandroidx.databinding.FragmentLoginBinding;
import com.example.projectandroidx.databinding.FragmentRegisterBinding;
import com.example.projectandroidx.ui.login.LoginFragment;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RegisterViewModel slideshowViewModel =
                new ViewModelProvider(this).get(RegisterViewModel.class);

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RegisterFragment.this)
                        .navigate(R.id.action_nav_register_to_nav_home);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}