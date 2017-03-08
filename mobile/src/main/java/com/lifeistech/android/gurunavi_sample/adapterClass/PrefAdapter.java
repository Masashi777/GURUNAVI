package com.lifeistech.android.gurunavi_sample.adapterClass;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lifeistech.android.gurunavi_sample.R;
import com.lifeistech.android.gurunavi_sample.gurunavi.prefSearchAPI.Pref;

import java.util.ArrayList;

/**
 * Created by Masashi Hamaguchi on 2017/03/08.
 */

public class PrefAdapter extends ArrayAdapter<Pref> {

    ArrayList<Pref> items;

    public PrefAdapter(Context context, int resource, ArrayList<Pref> objects) {
        super(context, resource, objects);
        items = objects;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Pref getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Pref item = getItem(position);
        final PrefAdapter.ViewHolder viewHolder;

        if (convertView != null) {
            viewHolder = (PrefAdapter.ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.area_list, parent, false);

            viewHolder = new PrefAdapter.ViewHolder();
            viewHolder.prefText = (TextView) convertView.findViewById(R.id.areaText);
            viewHolder.prefText.setTextColor(Color.BLACK);

            convertView.setTag(viewHolder);
        }

        viewHolder.prefText.setText(item.getPref_name());

        return convertView;
    }

    static class ViewHolder {
        TextView prefText;
    }
}
