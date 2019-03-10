package com.example.study;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderAdapter;

/**
 * Created by Administrator on 2019/2/26.
 */

public class MyAdapter extends RecyclerView.Adapter implements StickyHeaderAdapter {
    ArrayList<Bean> beans = new ArrayList<>();
    Context mContext;
    private char lastChar = '\u0000';
    private int DisplayIndex = 0;
    private final LayoutInflater mInflater;

    public MyAdapter(ArrayList<Bean> bean, Context context) {
        mInflater = LayoutInflater.from(context);
        this.beans = bean;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        MyViewHolder holder1 = (MyViewHolder) holder;
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ArrayList<String> list = beans.get(position).getList();

        for (int i = 0; i < list.size(); i++) {
            TextView textView = new TextView(mContext);
            textView.setLayoutParams(layoutParams);
            textView.setLineSpacing(1.2f, 1.2f);//设置行间距
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            textView.setText(list.get(i));
            textView.setTextColor(Color.parseColor("#2C2C2C"));
            textView.setPadding(calculateDpToPx(10), calculateDpToPx(6), 0, calculateDpToPx(6));
            holder1.mMyViewGroup.addView(textView, i, layoutParams);
        }
    }

    private int calculateDpToPx(int padding_in_dp) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (padding_in_dp * scale + 0.5f);
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    @Override
    public long getHeaderId(int position) {
        char ch = beans.get(position).getKey().charAt(0);
        if (lastChar == '\u0000') {
            lastChar = ch;
            return DisplayIndex;
        } else {
            if (lastChar == ch) {
                return DisplayIndex;
            } else {
                lastChar = ch;
                DisplayIndex++;
                return DisplayIndex;
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View inflate = mInflater.inflate(R.layout.title, parent, false);
        return new MyViewHolder2(inflate);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewholder, int position) {
        MyViewHolder2 holder2 = (MyViewHolder2) viewholder;

        holder2.mTitle.setText(beans.get(position).getKey());

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        //private TextView mTitle;
        private MyView4 mMyViewGroup;

        public MyViewHolder(View itemView) {
            super(itemView);
            // mTitle = itemView.findViewById(R.id.title);
            mMyViewGroup = itemView.findViewById(R.id.group);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {

        private TextView mTitle;


        public MyViewHolder2(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);

        }
    }
}
