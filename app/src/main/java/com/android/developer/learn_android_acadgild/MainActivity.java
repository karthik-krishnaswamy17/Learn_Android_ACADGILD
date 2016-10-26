package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Animation fadeIn;
    TextView textView;
    Button bt_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.id_text);
        bt_start = (Button) findViewById(R.id.bt_startAnim);
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        bt_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        textView.setVisibility(View.VISIBLE);
        textView.startAnimation(fadeIn);
    }
}
