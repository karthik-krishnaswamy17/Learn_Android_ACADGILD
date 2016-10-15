package com.android.developer.learn_android_acadgild;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.developer.learn_android_acadgild.adapter.CustomAdapter;
import com.android.developer.learn_android_acadgild.pojo.Websites;

import java.util.ArrayList;

/**
 * Created by karthik90 on 10/15/2016.
 */

public class CustomListActivity extends ListActivity {

    ArrayList<Websites> websitesArrayList = new ArrayList<>();
    private int websiteDrawableId[] = {R.drawable.youtube, R.drawable.blogger};
    private String websiteTitle[] = {"You Tube", "Blogger"};
    private String websiteDescription[] = {"Youtube Description", "Blogger Description"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlist);
        ListView listView = getListView();
        for (int i = 0; i < websiteDrawableId.length; i++)
            websitesArrayList.add(new Websites(websiteDrawableId[i], websiteTitle[i], websiteDescription[i]));
        listView.setAdapter(new CustomAdapter(this, websitesArrayList));
    }

}
