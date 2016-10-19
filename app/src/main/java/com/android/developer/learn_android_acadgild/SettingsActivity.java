package com.android.developer.learn_android_acadgild;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.android.developer.learn_android_acadgild.AppCompatPreference.AppCompatPreferenceActivity;


/**
 * Created by karthik90 on 10/19/2016.
 */

public class SettingsActivity extends AppCompatPreferenceActivity {
    private static int pref = R.xml.preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            getClass().getMethod("getFragmentManager");
            AddResourcesAPI11Above();
        } catch
                (NoSuchMethodException e) {
            AddResourcesAPI11Below();
        }
    }

    private void AddResourcesAPI11Below() {
        addPreferencesFromResource(pref);
    }

    @TargetApi(11)
    private void AddResourcesAPI11Above() {
        getFragmentManager().beginTransaction().replace(android.R.id.content, new FP()).commit();
    }

    public static class FP extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(SettingsActivity.pref);
        }
    }


}
