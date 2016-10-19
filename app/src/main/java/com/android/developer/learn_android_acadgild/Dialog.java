package com.android.developer.learn_android_acadgild;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by karthik90 on 10/19/2016.
 */

public class Dialog extends DialogFragment {
    private AlertDialog.Builder builder;

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.cancel);
        builder.setTitle("Confirm Delete...").
                setMessage("Are you sure you want to delete this ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        return builder.create();

    }
}


