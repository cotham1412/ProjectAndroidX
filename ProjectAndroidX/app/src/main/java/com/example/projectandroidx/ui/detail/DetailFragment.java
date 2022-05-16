package com.example.projectandroidx.ui.home1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.projectandroidx.MainActivity;
import com.example.projectandroidx.R;
import com.example.projectandroidx.databinding.FragmentHome1Binding;
import com.example.projectandroidx.databinding.FragmentHomeBinding;
import com.example.projectandroidx.ui.home.HomeFragment;
import com.example.projectandroidx.ui.home.HomeViewModel;

public class Home1Fragment extends Fragment {

    private FragmentHome1Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHome1Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button button = binding.button4;

        button.setText("ksksksk");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onCreateView: ");

                FragmentTransaction fragmentTransaction = getActivity()
                    .getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_home1, new HomeFragment());
            fragmentTransaction.commit();

//            Intent intent = new Intent(this, MainActivity.this);
//            startActivity(intent);
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