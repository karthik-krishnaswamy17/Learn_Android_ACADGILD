package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.android.developer.learn_android_acadgild.Adapter.CustomAdapter;
import com.android.developer.learn_android_acadgild.pojo.Versions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int[] ImageId = {R.drawable.logo_gingerbread, R.drawable.logo_honeycomb, R.drawable.logo_icecream,
            R.drawable.logo_jellybean, R.drawable.logo_kitkat, R.drawable.logo_lollipop, R.drawable.logo_marshmallow};
    private String[] Title = {"GingerBread", "HoneyComb", "IceCream", "JellyBean", "KitKat", "LolliPop", "MarshMallow"};
    private ArrayList<Versions> version;
    private GridView gridView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        version = new ArrayList<>();
        for (int i = 0; i < ImageId.length; i++) {
            version.add(new Versions(ImageId[i], Title[i]));
        }
        adapter = new CustomAdapter(this, version);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);


    }

}
