package com.example.administrator.xiaokao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ViewPager mVp;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        titles.add("首页");
        titles.add("我的");
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments, titles);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);

    }
}
