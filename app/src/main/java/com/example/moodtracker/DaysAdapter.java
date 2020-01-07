package com.example.moodtracker;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DaysAdapter extends ArrayAdapter<Days> {

    public DaysAdapter(Context context, List<Days> days) {
        super(context, 0, days);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_days,parent, false);
        }

        DaysViewHolder viewHolder = (DaysViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new DaysViewHolder();
            viewHolder.message_view = (TextView) convertView.findViewById(R.id.message_view);
            viewHolder.thumbnail_view = (ImageView) convertView.findViewById(R.id.thumbnail_view);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Days> tweets
        Days days = getItem(position);
        viewHolder.message_view.setText(days.getNameDay());
        viewHolder.thumbnail_view.setImageDrawable(new ColorDrawable(days.getColor()));

        return convertView;
    }

    private class DaysViewHolder{
        public TextView message_view;
        public ImageView thumbnail_view;

    }
}
