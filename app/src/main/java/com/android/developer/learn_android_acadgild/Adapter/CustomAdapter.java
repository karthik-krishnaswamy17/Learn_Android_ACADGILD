package com.android.developer.learn_android_acadgild.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.developer.learn_android_acadgild.R;
import com.android.developer.learn_android_acadgild.pojo.Versions;

import java.util.ArrayList;

/**
 * Created by karthik90 on 10/8/2016.
 */

public class CustomAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<Versions> version;

    public CustomAdapter() {
    }

    public CustomAdapter(Context c, ArrayList<Versions> ver) {
        this.context = c;
        this.version = ver;
        layoutInflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return version.size();
    }

    @Override
    public Object getItem(int position) {
        return version.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ImageHolder imageHolder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.layout_version_image, parent, false);
            imageHolder = new ImageHolder();
            imageHolder.imageView = (ImageView) v.findViewById(R.id.img_version);
            imageHolder.txt_title = (TextView) v.findViewById(R.id.txt_title);
            v.setTag(imageHolder);
        } else {
            imageHolder = (ImageHolder) v.getTag();
        }
        Versions v_obj = version.get(position);
        imageHolder.imageView.setImageResource(v_obj.getImageId());
        imageHolder.txt_title.setText(v_obj.getTitle());
        return v;
    }

}

class ImageHolder {
    ImageView imageView;
    TextView txt_title;
}
