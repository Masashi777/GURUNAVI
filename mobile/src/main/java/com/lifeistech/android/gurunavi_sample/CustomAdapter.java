package com.lifeistech.android.gurunavi_sample;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.Rest;

import java.util.ArrayList;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class CustomAdapter extends ArrayAdapter<Rest> {

    ArrayList<Rest> items;

    public CustomAdapter(Context context, int resource, ArrayList<Rest> objects) {
        super(context, resource, objects);
        items = objects;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Rest getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Rest item = getItem(position);
        final ViewHolder viewHolder;

        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.rest_list, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.nameText);
            viewHolder.name.setTextColor(Color.BLACK);
            viewHolder.address = (TextView) convertView.findViewById(R.id.addressText);
            viewHolder.address.setTextColor(Color.BLACK);

            convertView.setTag(viewHolder);
        }

        viewHolder.name.setText(item.getName());
        viewHolder.address.setText(item.getAddress());

        return convertView;


    }


    static class ViewHolder {
        TextView name;
        TextView address;
    }

}
