package com.android.developer.learn_android_acadgild.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.developer.learn_android_acadgild.R;
import com.android.developer.learn_android_acadgild.pojo.Websites;

import java.util.ArrayList;

/**
 * Created by karthik90 on 10/15/2016.
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Websites> websitesArrayList;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context c, ArrayList<Websites> websites) {
        this.context = c;
        this.websitesArrayList = websites;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return websitesArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return websitesArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder = new ViewHolder();
        if (v == null) {
            v = layoutInflater.inflate(R.layout.custom_layout, parent, false);
            viewHolder.imageView = (ImageView) v.findViewById(R.id.Logo);
            viewHolder.Title = (TextView) v.findViewById(R.id.text_title);
            viewHolder.Description = (TextView) v.findViewById(R.id.text_description);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }
        viewHolder.imageView.setImageResource(websitesArrayList.get(position).getWebsiteDrawableId());
        viewHolder.Title.setText(websitesArrayList.get(position).getWebsiteTitle());
        viewHolder.Description.setText(websitesArrayList.get(position).getWebsiteDescription());
        return v;
    }
}

class ViewHolder {
    ImageView imageView;
    TextView Title, Description;
}