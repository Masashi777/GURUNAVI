package com.lifeistech.android.gurunavi_sample.adapterClass;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeistech.android.gurunavi_sample.MainActivity;
import com.lifeistech.android.gurunavi_sample.R;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.Rest;
import com.squareup.picasso.Picasso;

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
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            viewHolder.name = (TextView) convertView.findViewById(R.id.nameText);
            viewHolder.name.setTextColor(Color.BLACK);

            viewHolder.access = (TextView) convertView.findViewById(R.id.accessText);
            viewHolder.budget = (TextView) convertView.findViewById(R.id.budgetText);
            viewHolder.pr = (TextView) convertView.findViewById(R.id.prText);

            viewHolder.address = (TextView) convertView.findViewById(R.id.addressText);
            viewHolder.address.setTextColor(Color.BLACK);

            convertView.setTag(viewHolder);
        }

//        Picasso.with(getContext()).load(item.getImageURL().getShopImage1()).into(viewHolder.imageView);
        viewHolder.name.setText(item.getName());
        viewHolder.access.setText(item.getAccess().getStation() + " " + item.getAccess().getStationExit() + " 徒歩 " + item.getAccess().getWalk() + "分");
        viewHolder.budget.setText("平均予算 " + item.getBudget() + " ハーティー予算 " + item.getParty());
        viewHolder.pr.setText(item.getPr().getPrShort());
        viewHolder.address.setText(item.getAddress());

        return convertView;


    }


    static class ViewHolder {
        ImageView imageView;

        TextView name;
        TextView access;
        TextView budget;
        TextView pr;
        TextView address;
    }

}
