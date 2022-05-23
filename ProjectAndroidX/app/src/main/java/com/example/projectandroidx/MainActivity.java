package com.example.projectandroidx;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;

import com.example.projectandroidx.ui.Adapter.MyRecycleViewAdapter;
import com.example.projectandroidx.ui.Product;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroidx.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private ArrayList<Product> products = new ArrayList<Product> ();
    private ArrayAdapter<Product> adapter;

//     cac buoc tao 1 muc trong nav :
//        b1: vao` muc. ui -> tao. package moi' dat ten theo chuc' nang -> tao. file Fragment va` file ViewModel
//        b2: vao` muc. navigation -> mobile_navigation.xml -> copy 1 fragment -> doi id fragment (co' nav o dau`)
//                  -> keo' ra 1 cho moi'
//        b3: vao` muc. layout -> tao. 1 fragment moi' , dat ten theo chuc' nang -> trang tri' trang do'
//        b4: vao` muc. res -> chuot phai-> new -> vector Asset -> chon. Local file -> dat ten vector theo icon
//                  ->  den phan` path thi` lan chuot. tim` icon can` dung`,chinh ti le neu can`-> next
//        b5: vao` MainActivity -> tai. dong` mAppBarConfiguration = new AppBarConfiguration.Builder
//                  -> them R.id. (ten id moi' dat. o b2)
//        b6: vao` values -> string.xml -> them string name theo chuc' nang
//        b7: vao` menu -> activity-main -> them 1 muc vao` , doi icon



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_register,
                R.id.nav_cart,
                R.id.nav_login,
                R.id.nav_product,
                R.id.nav_detail
        )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        //ListView list = findViewById(R.id.list);
        RecyclerView list = findViewById(R.id.list);
        adapter = new MyRecycleViewAdapter(this, R.layout.home_card_view, R.layout.fragment_home, products);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

//        code ngay` 21/3
        GridLayoutManager lienerLayoutManager = new GridLayoutManager(this, 2);

        // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //code chay theo chiu` ngang
        // LinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

//        code ngay` 21/3
        //do du lieu vao`
        list.setLayoutManager(lienerLayoutManager);
        //cài đặt adapter
        list.setAdapter(adapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu); //...
//
////        Log.d("123", "onCreateOptionsMenu: "+ );
//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}