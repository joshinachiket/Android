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

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
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
        holder.isAlive = true;
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public class ViewHolder {
        boolean isAlive;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,
            R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell,R.drawable.alivecell, R.drawable.alivecell
    };
}