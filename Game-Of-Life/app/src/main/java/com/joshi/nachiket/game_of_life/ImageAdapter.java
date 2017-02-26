package com.joshi.nachiket.game_of_life;

/**
 * Created by NACHIKET on 2/17/2017.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Boolean> list;
    public static int GRID_SIZE;

    // Constructor
    public ImageAdapter(Context c,ArrayList<Boolean> list) {
        mContext = c;
        this.list = list;
        GRID_SIZE = Integer.parseInt(c.getResources().getString(R.string.grid_size));
    }

    public int getCount() {
        return GRID_SIZE;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(60, 60));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setTag(holder);
        }
        else
        {
            imageView = (ImageView) convertView;
            holder = (ViewHolder) imageView.getTag();
        }
        holder.isAlive = list.get(position);
        if(holder.isAlive) {
            imageView.setImageResource(R.drawable.alivecell);
        } else {
            imageView.setImageResource(R.drawable.deadcell);
        }

        return imageView;
    }

    public class ViewHolder {
        boolean isAlive;
    }

}