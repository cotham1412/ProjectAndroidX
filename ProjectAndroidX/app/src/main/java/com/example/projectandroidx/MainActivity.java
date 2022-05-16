package com.example.projectandroidx;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectandroidx.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

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
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_detail)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
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