package com.android.developer.learn_android_acadgild.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.developer.learn_android_acadgild.R;
import com.android.developer.learn_android_acadgild.mbeans.Contacts;

import java.util.ArrayList;

/**
 * Created by karthik90 on 10/12/2016.
 */

public class Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Contacts> contacts;
    private LayoutInflater layoutInflater;

    public Adapter() {
    }

    public Adapter(Context c, ArrayList<Contacts> contacts) {
        this.context = c;
        this.contacts = contacts;
        layoutInflater = LayoutInflater.from(this.context);
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder;
        if (v == null) {
            viewHolder = new ViewHolder();
            v = layoutInflater.inflate(R.layout.custom_listview, parent, false);
            viewHolder.name = (TextView) v.findViewById(R.id.name);
            viewHolder.phone = (TextView) v.findViewById(R.id.phone);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }
        viewHolder.name.setText(contacts.get(position).getName());
        viewHolder.phone.setText(contacts.get(position).getPhone());


        return v;
    }

    class ViewHolder {
        TextView name, phone;
    }
}
