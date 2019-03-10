package com.example.administrator.xiaokao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/29.
 */

public class DataAdapter extends RecyclerView.Adapter {
    ArrayList<Bean.RecentBean> mList;
    Context mContext;
    public ViewPager mVpp;
    private OnClickListener mListener;

    public DataAdapter(ArrayList<Bean.RecentBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if(viewType == 0){
           View view = LayoutInflater.from(mContext).inflate(R.layout.item, null, false);
          return new MyViewHolder(view);
       }else if(viewType == 1){
           View view = LayoutInflater.from(mContext).inflate(R.layout.item2, null, false);
           return new MyViewHolder2(view);
       }else if(viewType == 2){
           View view = LayoutInflater.from(mContext).inflate(R.layout.item3, null, false);
           return new MyViewHolder3(view);
       }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);

        if(viewType == 0){
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < mList.size(); i++) {
                strings.add(mList.get(i).getThumbnail());
            }
            MyViewHolder holder1 = (MyViewHolder) holder;
            MyPage myPage = new MyPage(strings,mContext);
            holder1.mVpp.setAdapter(myPage);
            mVpp = holder1.mVpp;

        }else if(viewType == 1){
                MyViewHolder2 holder2 = (MyViewHolder2) holder;
                holder2.mTv.setText(mList.get(position-1).getTitle());
            Glide.with(mContext).load(mList.get(position-1).getThumbnail()).into(holder2.mImg);
        }else if(viewType == 2){
            MyViewHolder3 holder3 = (MyViewHolder3) holder;
            holder3.mTv.setText(mList.get(position-1).getTitle());
            Glide.with(mContext).load(mList.get(position-1).getThumbnail()).into(holder3.mImg);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onclick(position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 0;
        }else if(position%2==0){
            return 1;
        }else{
            return 2;
        }

    }

    @Override
    public int getItemCount() {
        return mList.size()+1;
    }

    public void addData(List<Bean.RecentBean> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private  ViewPager mVpp;

        public MyViewHolder(View itemView) {
            super(itemView);
            mVpp = itemView.findViewById(R.id.vpp);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder{


        private  ImageView mImg;
        private  TextView mTv;

        public MyViewHolder2(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img);
            mTv = itemView.findViewById(R.id.tv);
        }
    }
    class MyViewHolder3 extends RecyclerView.ViewHolder{


        private  ImageView mImg;
        private  TextView mTv;

        public MyViewHolder3(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img);
            mTv = itemView.findViewById(R.id.tv);
        }
    }
    public interface OnClickListener{
        void onclick(int position);
    }
    public void setOnClickListener(OnClickListener listener){
        this.mListener = listener;
    }
}
