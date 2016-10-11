package com.android.developer.learn_android_acadgild;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt_submenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.red: {
                txt.setTextColor(Color.RED);
                break;
            }

            case R.id.green: {
                txt.setTextColor(Color.GREEN);
                break;
            }

            case R.id.blue: {
                txt.setTextColor(Color.BLUE);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
