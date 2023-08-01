package com.sunday_practice;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences mySharedPref;

    public SharedPref(Context context) {
        mySharedPref = context.getSharedPreferences("my_preferences", context.MODE_PRIVATE);
    }

    //this method will save the nightMode state : True or False
    public void setNightModeState(Boolean state) {
        SharedPreferences.Editor editor = mySharedPref.edit();  //help in accessing the key-value pairs
        editor.putBoolean("NightMode", state);  //saving key-value pair
        editor.commit();    //save changes
    }

    //this method will load the Night Mode state
    public Boolean loadNightModeState() {
        Boolean state = mySharedPref.getBoolean("NightMode", false);
        return state;
    }
}
