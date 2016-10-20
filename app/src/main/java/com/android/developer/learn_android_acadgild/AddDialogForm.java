package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by karthik90 on 10/20/2016.
 */

public class AddDialogForm extends DialogFragment implements View.OnClickListener {
    Button bt_save, bt_cancel;
    EditText name, phone, dob;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_form_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bt_save = (Button) view.findViewById(R.id.bt_save);
        bt_cancel = (Button) view.findViewById(R.id.bt_cancel);
        bt_save.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
        name = (EditText) view.findViewById(R.id.name);
        phone = (EditText) view.findViewById(R.id.phone);
        dob = (EditText) view.findViewById(R.id.dob);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_save:
                String Name = name.getText().toString();
                String Phone = phone.getText().toString();
                String Dob = dob.getText().toString();
                DialogForm mainActivity = (MainActivity) getActivity();
                mainActivity.onFinishDialog(Name, Phone, Dob);
                dismiss();
                break;
            case R.id.bt_cancel:
                dismiss();
                break;
        }


    }

    public interface DialogForm {
        void onFinishDialog(String name, String phone, String dob);
    }
}
