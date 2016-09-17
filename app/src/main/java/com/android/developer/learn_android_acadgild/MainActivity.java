package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.bt_id);
        img = (ImageView) findViewById(R.id.img_profile);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bt_text = bt.getText().toString();
                String hide_text = getResources().getString(R.string.hide_button);
                if (bt_text.equals(hide_text)) {
                    img.setVisibility(View.INVISIBLE);
                    bt.setText(getResources().getString(R.string.show_button));
                } else {
                    img.setVisibility(View.VISIBLE);
                    bt.setText(getResources().getString(R.string.hide_button));
                }

            }
        });
    }

}
