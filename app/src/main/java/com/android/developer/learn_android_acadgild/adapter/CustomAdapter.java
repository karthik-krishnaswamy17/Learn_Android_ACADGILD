package com.android.developer.learn_android_acadgild.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.developer.learn_android_acadgild.R;
import com.android.developer.learn_android_acadgild.mbeans.ContactsHandler;

import java.util.ArrayList;

/**
 * Created by karthik90 on 10/7/2016.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<ContactsHandler> contacts = new ArrayList<>();
    LayoutInflater inflater;

    public CustomAdapter() {
    }

    public CustomAdapter(Context context, ArrayList<ContactsHandler> data) {
        this.context = context;
        this.contacts = data;
        Log.v("state", "ContactsList:" + contacts.size());
        inflater = LayoutInflater.from(context);
        Log.v("state", "LayoutInflater:" + inflater);
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder mholder;
        if (v == null) {
            v = inflater.inflate(R.layout.custom_list, parent, false);
            mholder = new ViewHolder();
            mholder.name = (TextView) v.findViewById(R.id.txt_name);
            mholder.phone = (TextView) v.findViewById(R.id.txt_phone);
            v.setTag(mholder);
        } else {
            mholder = (ViewHolder) v.getTag();

        }
        mholder.name.setText(contacts.get(position).getName());
        mholder.phone.setText(contacts.get(position).getPhone());
        return v;
    }
}

class ViewHolder {
    TextView name, phone;

}