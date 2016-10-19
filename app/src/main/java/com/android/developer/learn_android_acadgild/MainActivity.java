package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_click = (Button) findViewById(R.id.bt_click);
        bt_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog();
                dialog.setCancelable(false);
                dialog.show(getSupportFragmentManager(), "Dialog");
            }
        });

    }
}
