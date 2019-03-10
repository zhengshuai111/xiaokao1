package com.example.administrator.xiaokao;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.xiaokao.m.ImlM;
import com.example.administrator.xiaokao.p.ImlP;
import com.example.administrator.xiaokao.v.MainView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/29.
 */

public class OneFragment extends Fragment implements MainView {

    private MainActivity mActivity;
    private View view;
    private RecyclerView mRv;
    private DataAdapter mAdapter;
    private int page = 1;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                        mAdapter.mVpp.setCurrentItem(page);
                        page++;
                    if(page == mAdapter.mList.size()){
                        page = 0;
                    }



                    break;

            }

        }
    };
    private ArrayList<Bean.RecentBean> mList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one, null, false);
        mActivity = (MainActivity) getActivity();
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        ImlP imlP = new ImlP(new ImlM(), this);
        imlP.getDataP();
    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(mActivity));
        mRv.addItemDecoration(new DividerItemDecoration(mActivity,DividerItemDecoration.VERTICAL));
        mList = new ArrayList<>();
        mAdapter = new DataAdapter(mList, mActivity);
        mRv.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new DataAdapter.OnClickListener() {
            @Override
            public void onclick(int position) {
                String thumbnail = mList.get(position-1).getThumbnail();
                EventBus.getDefault().postSticky(thumbnail);
                mActivity.mVp.setCurrentItem(1);
            }
        });
    }

    @Override
    public void showData(List<Bean.RecentBean> list) {
        mAdapter.addData(list);
       lun();
    }

    private void lun() {
        new Thread(){
            @Override
            public void run() {
                super.run();

                while (page<mAdapter.mList.size()){

                    try {
                        sleep(2000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    mHandler.sendEmptyMessage(1);
                }

            }
        }.start();
    }
}
