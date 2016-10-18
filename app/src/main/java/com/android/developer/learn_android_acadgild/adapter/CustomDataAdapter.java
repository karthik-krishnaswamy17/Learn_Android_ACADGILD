package com.android.developer.learn_android_acadgild.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.developer.learn_android_acadgild.R;
import com.android.developer.learn_android_acadgild.model.Data;

import java.util.ArrayList;

/**
 * Created by karthik90 on 10/18/2016.
 */

public class CustomDataAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Data> data;

    public CustomDataAdapter(Context c, ArrayList<Data> data) {
        this.context = c;
        layoutInflater = LayoutInflater.from(context);
        this.data = data;


    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
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
            v = layoutInflater.inflate(R.layout.cutsom_layout, parent, false);
            holder.id = (TextView) v.findViewById(R.id.dataId);
            holder.fname = (TextView) v.findViewById(R.id.fname);
            holder.lname = (TextView) v.findViewById(R.id.lname);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();

        }

        holder.id.setText(data.get(position).getId());
        holder.fname.setText(data.get(position).getFirstname());
        holder.lname.setText(data.get(position).getLastname());

        return v;
    }
}

class ViewHolder {
    TextView id, fname, lname;


}
