package com.android.developer.learn_android_acadgild;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.developer.learn_android_acadgild.adapter.CustomAdapter;
import com.android.developer.learn_android_acadgild.mbeans.ContactsHandler;

import java.util.ArrayList;

/**
 * Created by karthik90 on 10/7/2016.
 */

public class ListViewActivity extends ListActivity implements AdapterView.OnItemClickListener {
    private static String names[] = {"Name1", "Name2", "Name3", "Name4", "Name5", "Name6", "Name7"};
    private static String phone[] = {"PhoneNumber1", "PhoneNumber2", "PhoneNumber3", "PhoneNumber4",
            "PhoneNumber5", "PhoneNumber6", "PhoneNumber7"};
    private ArrayList<ContactsHandler> contacts;
    private ListView list_contacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        list_contacts = getListView();
        contacts = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            contacts.add(new ContactsHandler(names[i], phone[i]));
        }
        CustomAdapter adapter = new CustomAdapter(this, contacts);
        setListAdapter(adapter);
        list_contacts.setOnItemClickListener(this);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView c_name = (TextView) view.findViewById(R.id.txt_name);
        TextView c_phone = (TextView) view.findViewById(R.id.txt_phone);
        String clicked = c_name.getText().toString().toUpperCase() + "\n" + c_phone.getText();
        Toast.makeText(this, clicked, Toast.LENGTH_SHORT).show();

    }
}
