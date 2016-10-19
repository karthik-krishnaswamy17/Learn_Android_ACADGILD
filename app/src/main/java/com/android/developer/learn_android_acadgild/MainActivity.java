package com.android.developer.learn_android_acadgild;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt_settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_settings = (Button) findViewById(R.id.bt_settings);
        bt_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(settings);
            }
        });

        display();

    }

    private void display() {
        boolean screenLock;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        screenLock = sp.getBoolean("screenLock", false);
        Log.v("state", "screenLock:" + screenLock);
        String reminderValue;
        reminderValue = sp.getString("keyReminder", null);
        Log.v("state", "Reminder:" + reminderValue);
    }
}
