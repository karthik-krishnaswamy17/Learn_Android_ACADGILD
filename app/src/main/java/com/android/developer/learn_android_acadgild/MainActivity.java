package com.android.developer.learn_android_acadgild;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    final private String QUERY = "https://www.google.com/search?q=";
    ImageView img_search;
    EditText search_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_search = (ImageView) findViewById(R.id.search_img);
        search_query = (EditText) findViewById(R.id.txt_search);
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = QUERY + (search_query.getText());
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
            }

        });

    }


}
