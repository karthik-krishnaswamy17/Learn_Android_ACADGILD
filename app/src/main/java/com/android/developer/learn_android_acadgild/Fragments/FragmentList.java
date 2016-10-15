package com.android.developer.learn_android_acadgild.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;

import com.android.developer.learn_android_acadgild.R;
import com.android.developer.learn_android_acadgild.adapter.CustomAdapter;
import com.android.developer.learn_android_acadgild.pojo.Websites;

import java.util.ArrayList;

/**
 * Created by karthik90 on 10/15/2016.
 */

public class FragmentList extends ListFragment {
    ArrayList<Websites> websitesArrayList = new ArrayList<>();
    private int websiteDrawableId[] = {R.drawable.youtube, R.drawable.blogger};
    private String websiteTitle[] = {"You Tube", "Blogger"};
    private String websiteDescription[] = {"Youtube Description", "Blogger Description"};

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 0; i < websiteDrawableId.length; i++)
            websitesArrayList.add(new Websites(websiteDrawableId[i], websiteTitle[i], websiteDescription[i]));
        setListAdapter(new CustomAdapter(getActivity(), websitesArrayList));

    }

}


