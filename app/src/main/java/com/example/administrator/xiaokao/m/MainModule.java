package com.example.administrator.xiaokao.m;

import com.example.administrator.xiaokao.Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/12/29.
 */

public interface MainModule {
    interface Finish{
        void setData(List<Bean.RecentBean> list);
    }
    void getDataM(Finish finish);
}
