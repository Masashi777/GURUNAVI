package com.lifeistech.android.gurunavi_sample.adapterClass;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lifeistech.android.gurunavi_sample.R;
import com.lifeistech.android.gurunavi_sample.gurunavi.areaSearchAPI.Area;

import java.util.ArrayList;

/**
 * Created by Masashi Hamaguchi on 2017/03/08.
 */

public class AreaAdapter extends ArrayAdapter<Area> {

    ArrayList<Area> items;

    public AreaAdapter(Context context, int resource, ArrayList<Area> objects) {
        super(context, resource, objects);
        items = objects;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Area getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Area item = getItem(position);
        final AreaAdapter.ViewHolder viewHolder;

        if (convertView != null) {
            viewHolder = (AreaAdapter.ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.area_list, parent, false);

            viewHolder = new AreaAdapter.ViewHolder();
            viewHolder.areaText = (TextView) convertView.findViewById(R.id.areaText);
            viewHolder.areaText.setTextColor(Color.BLACK);

            convertView.setTag(viewHolder);
        }

        viewHolder.areaText.setText(item.getArea_name());

        return convertView;
    }

    static class ViewHolder {
        TextView areaText;
    }
}
