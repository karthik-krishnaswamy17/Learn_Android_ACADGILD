package com.android.developer.learn_android_acadgild;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by karthik90 on 10/25/2016.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private String[] versions;

    public Adapter(String[] versions) {
        this.versions = versions;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {

        holder.title.setText(versions[position]);

    }

    @Override
    public int getItemCount() {
        return versions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.titleVersion);

        }
    }
}
