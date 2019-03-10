package com.example.administrator.xiaokao.p;

import com.example.administrator.xiaokao.Bean;
import com.example.administrator.xiaokao.m.MainModule;
import com.example.administrator.xiaokao.v.MainView;

import java.util.List;

/**
 * Created by Administrator on 2018/12/29.
 */

public class ImlP implements MainPre, MainModule.Finish {
    private MainModule mMainModule;
    private MainView mMainView;

    public ImlP(MainModule mainModule, MainView mainView) {
        mMainModule = mainModule;
        mMainView = mainView;
    }

    @Override
    public void getDataP() {
        mMainModule.getDataM(this);
    }

    @Override
    public void setData(List<Bean.RecentBean> list) {
                mMainView.showData(list);
    }
}
