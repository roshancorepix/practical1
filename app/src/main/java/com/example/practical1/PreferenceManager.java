package com.example.practical1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.UserHandle;

public class PreferenceManager {

    private static SharedPreferences preferences;
    private static final String PREF_NAME = "pref";
    private static final String USER_NAME = "Username";

    public PreferenceManager() {
    }

    public static void init(Context context){
        if (preferences == null){
            preferences = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        }
    }

    public static void setUsername(String username){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_NAME, username);
        editor.commit();
    }

    public static String getUserName(){
        return preferences.getString(USER_NAME, "");
    }
}
