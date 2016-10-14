package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_submit;
    SimpleAddition fragmentA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(this);
        fragmentA = (SimpleAddition) getSupportFragmentManager().findFragmentById(R.id.fragment_details);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_details, fragmentA).commit();

    }

    public void onClick(View v) {
        TextView textView = (TextView) findViewById(R.id.textView);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String value = editText.getText().toString();
        textView.setText(value);
    }
}
