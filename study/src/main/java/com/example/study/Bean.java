package com.example.study;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Administrator on 2019/2/26.
 */

public class Bean {
    String key;
    ArrayList<String> mList;

    public Bean(String key, ArrayList<String> list) {
        this.key = key;
        mList = list;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<String> getList() {
        return mList;
    }

    public void setList(ArrayList<String> list) {
        mList = list;
    }
}
