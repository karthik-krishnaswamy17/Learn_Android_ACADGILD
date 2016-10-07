package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.widget.TextView;

public class LoginScreen extends BaseMenuActivity {
    TextView textView;
    private String welcomeMessage = "Welcome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        textView = (TextView) findViewById(R.id.txt_user);
        String user = getIntent().getExtras().getString("username");
        if (user != null)
            textView.setText(welcomeMessage + " " + user + ",");

    }
}
