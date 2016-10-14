package com.android.developer.learn_android_acadgild;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.android.developer.learn_android_acadgild.Data.layoutNames;

/**
 * Created by karthik90 on 10/14/2016.
 */

public class Fragment_LayoutNames extends ListFragment {
    ArrayAdapter<String> adapter;
    Boolean mDualPane;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new ArrayAdapter<>(getActivity(), R.layout.simple_custom_list, R.id.id_layoutNames, layoutNames);
        setListAdapter(adapter);
        View details_description = getActivity().findViewById(R.id.details_description);
        mDualPane = (details_description != null) && (details_description.getVisibility() == View.VISIBLE);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    private void showDetails(int position) {
        int index = position;
        if (mDualPane) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            Fragment_Description desc = (Fragment_Description) getFragmentManager().findFragmentById(R.id.details_description);

            if (desc == null || desc.getShownIndex() != index) {
                desc = Fragment_Description.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details_description, desc);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

        } else {
            Intent intent = new Intent(getActivity(), Activity_Description.class);
            intent.putExtra("index", index);
            startActivity(intent);


        }

    }

}
