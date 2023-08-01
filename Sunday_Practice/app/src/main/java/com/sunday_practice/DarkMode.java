package com.sunday_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class DarkMode extends AppCompatActivity {

    private Switch mySwitch;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = new SharedPref(this);
        if(sharedPref.loadNightModeState() == true) {
            setTheme(R.style.Theme_light);
        } else setTheme(R.style.Theme_dark);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark_mode);

        mySwitch = (Switch) findViewById(R.id.mySwitch);
        if(sharedPref.loadNightModeState() == true) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            mySwitch.setChecked(true);
        }
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sharedPref.setNightModeState(true); //changing the App theme to darkMode
                    System.out.println("DarkMode Set");
                    restartApp();
                } else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sharedPref.setNightModeState(false);
                    System.out.println("LightMode Set");

                    restartApp();
                }
            }
        });
    }

    public void restartApp() {
        Intent i = new Intent(getApplicationContext(), DarkMode.class);
        startActivity(i);
        finish();   //destroy the current activity
    }
}