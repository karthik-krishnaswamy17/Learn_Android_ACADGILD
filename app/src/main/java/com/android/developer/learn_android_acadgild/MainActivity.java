package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.developer.learn_android_acadgild.adapter.CustomAdapter;
import com.android.developer.learn_android_acadgild.mbeans.ContactsHandler;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static String names[] = {"Name1", "Name2", "Name3", "Name4", "Name5", "Name6", "Name7"};
    private static String phone[] = {"PhoneNumber1", "PhoneNumber2", "PhoneNumber3", "PhoneNumber4",
            "PhoneNumber5", "PhoneNumber6", "PhoneNumber7"};
    private ArrayList<ContactsHandler> contacts;
    private ListView list_contacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_contacts = (ListView) findViewById(R.id.list_contacts);
        contacts = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            contacts.add(new ContactsHandler(names[i], phone[i]));
        }
        CustomAdapter adapter = new CustomAdapter(this, contacts);
        list_contacts.setAdapter(adapter);

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
