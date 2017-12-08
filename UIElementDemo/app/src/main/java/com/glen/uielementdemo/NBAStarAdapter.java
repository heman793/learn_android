package com.glen.uielementdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by heman on 17/11/16.
 */

public class NBAStarAdapter extends BaseAdapter {

    private LinkedList<NBAStar> data;
    private Context context;

    public NBAStarAdapter(LinkedList<NBAStar> data, Context context)
    {
        this.data = data;
        this.context =context;
    }

    @Override
    public int getCount(){
        return data.size();
    }

    @Override
    public Object getItem(int position){
        return null;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list_nbastar,parent,false);

        ImageView iv =  (ImageView) convertView.findViewById(R.id.img_icon);
        TextView tvName = (TextView) convertView.findViewById(R.id.name);
        TextView tvMotto = (TextView) convertView.findViewById(R.id.motto);

        iv.setBackgroundResource(data.get(position).getIcon());
        tvName.setText(data.get(position).getName());
        tvMotto.setText(data.get(position).getMotto());

        return convertView;
    }

}
