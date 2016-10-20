package com.android.developer.learn_android_acadgild.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.developer.learn_android_acadgild.R;
import com.android.developer.learn_android_acadgild.mBeans.Details;

import java.util.ArrayList;

/**
 * Created by karthik90 on 10/20/2016.
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Details> detail;
    private LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Details> d) {
        context = c;
        detail = d;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return detail.size();
    }

    @Override
    public Object getItem(int position) {
        return detail.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            holder = new ViewHolder();
            v = inflater.inflate(R.layout.layout_custom_list, parent, false);
            holder.name = (TextView) v.findViewById(R.id.listName);
            holder.phone = (TextView) v.findViewById(R.id.listPhone);
            holder.dob = (TextView) v.findViewById(R.id.listDob);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.name.setText(detail.get(position).getName());
        holder.phone.setText(detail.get(position).getPhone());
        holder.dob.setText(detail.get(position).getDob());
        return v;
    }

    class ViewHolder {
        TextView name, phone, dob;
    }
}
