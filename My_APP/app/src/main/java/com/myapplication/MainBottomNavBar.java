package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainBottomNavBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottom_nav_bar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);

        replaceFragment(new HomeFragment());

        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            int a = item.getItemId();

            if(a == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (a == R.id.shorts) {
                replaceFragment(new ShortsFragment());
            } else if (a == R.id.subscriptions) {
                replaceFragment(new SubscriptionsFragment());
            } else if (a == R.id.library) {
                replaceFragment(new LibraryFragment());
            }
            return true;
        });
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}