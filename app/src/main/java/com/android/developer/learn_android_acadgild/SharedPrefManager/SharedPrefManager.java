package com.android.developer.learn_android_acadgild.SharedPrefManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPrefManager {
    public static SharedPreferences getSharedPref(Context mContext) {
        SharedPreferences pref = mContext.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return pref;
    }

    public static void setStringPrefVal(Context mContext, String key, String value) {
        Editor edit = getSharedPref(mContext).edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static void setIntPrefVal(Context mContext, String key, int value) {
        Editor edit = getSharedPref(mContext).edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public static void setBooleanPrefVal(Context mContext, String key, boolean value) {
        Editor edit = getSharedPref(mContext).edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static boolean getBooleanPrefVal(Context mContext, String key) {
        SharedPreferences pref = getSharedPref(mContext);
        boolean val = false;
        if (pref.contains(key))
            val = pref.getBoolean(key, false);
        else
            val = false;
        return val;
    }

    public static String getPrefVal(Context mContext, String key) {
        SharedPreferences pref = getSharedPref(mContext);
        String val = "";
        if (pref.contains(key))
            val = pref.getString(key, "");
        else
            val = "";
        return val;
    }

    public static int getIntPrefVal(Context mContext, String key) {
        SharedPreferences pref = getSharedPref(mContext);
        int val = 0;
        if (pref.contains(key)) val = pref.getInt(key, 0);
        return val;
    }
}
