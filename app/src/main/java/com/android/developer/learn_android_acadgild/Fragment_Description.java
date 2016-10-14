package com.android.developer.learn_android_acadgild;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by karthik90 on 10/14/2016.
 */

public class Fragment_Description extends Fragment {

    public static Fragment_Description newInstance(int index) {
        Fragment_Description f = new Fragment_Description();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView text = new TextView(getActivity());
        text.setGravity(Gravity.CENTER_HORIZONTAL);
        if (getActivity().getResources().getConfiguration().orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            text.setTextColor(Color.BLACK);
        else
            text.setTextColor(Color.WHITE);
        text.setText(Data.layoutDescription[getShownIndex()]);
        return text;
    }
}
