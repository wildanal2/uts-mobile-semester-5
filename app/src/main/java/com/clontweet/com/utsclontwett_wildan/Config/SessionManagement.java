package com.clontweet.com.utsclontwett_wildan.Config;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.clontweet.com.utsclontwett_wildan.MainActivity;

import java.util.HashMap;

public class SessionManagement {
    //Share preference
    private SharedPreferences mSharedPreference;
    //Editor for Shared preference
    private SharedPreferences.Editor mEditor;
    //context
    private Context mContext;
    //Shared pref mode
    int PRIVATE_MODE;
    //Shared pref name
     private static final String PREF_NAME = "SharedPrefLatihan";
     //Shared Preferences Keys
     private static final String IS_LOGIN = "IsLoggedIn";
     public static final String KEY_EMAIL = "email";
     public static final String KEY_PASSWOrD = "pswd";

    public SessionManagement(Context mContext) {
        this.mContext = mContext;
        mSharedPreference = this.mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mSharedPreference.edit();
    }

    public void createLoginSession(String email, String password){
        // Storing login value as TRUE
         mEditor.putBoolean(IS_LOGIN, true);
         // Storing email
         mEditor.putString(KEY_EMAIL,email );
         // Storing password
         mEditor.putString(KEY_PASSWOrD,password );
         mEditor.commit();
    }

    public HashMap<String, String> getUserInformation(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user email
        user.put(KEY_EMAIL, mSharedPreference.getString(KEY_EMAIL, null));
        // user password
        user.put(KEY_PASSWOrD, mSharedPreference.getString(KEY_PASSWOrD, null));
        // return user
        return user;
    }

    public boolean isLoggedIn(){
        return mSharedPreference.getBoolean(IS_LOGIN, false);
    }

    public void checkIsLogin() {
        // Check login status
         if (!isLoggedIn()) {
             // user is not logged in redirect to MainActivity
              Intent i = new Intent(mContext, MainActivity.class);
             // Closing all the Activities
              i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             // Add new Flag to start new Activity
              i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              mContext.startActivity(i);
         }
    }

    public void logoutUser(){
        mEditor.clear();
        mEditor.commit();

    }
}
