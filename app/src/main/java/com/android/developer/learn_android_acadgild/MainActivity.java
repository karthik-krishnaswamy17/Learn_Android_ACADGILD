package com.android.developer.learn_android_acadgild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String user = "admin";
    private static final String pass = "password";
    Button bt_login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        username = (EditText) findViewById(R.id.txt_username);
        password = (EditText) findViewById(R.id.password);

        String username_value = username.getText().toString().toLowerCase();
        String password_value = password.getText().toString();

        if (username_value.equals(user))
            if (password_value.equals(pass)) {
                Bundle bundle = new Bundle();
                bundle.putString("username", username_value);
                Intent intent = new Intent(this, LoginScreen.class);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
            }

    }
}
