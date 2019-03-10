package com.example.administrator.xiaokao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/12/29.
 */

public class MyPage extends PagerAdapter {
    private  Context mContext;
    private  ArrayList<String> imgs;

    public MyPage(ArrayList<String> strings, Context context) {
        this.imgs = strings;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return imgs.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.lun, null, false);
        ImageView img = view.findViewById(R.id.img);
        Glide.with(mContext).load(imgs.get(position)).into(img);
        container.addView(view);

        return container.getChildAt(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

    }
}
