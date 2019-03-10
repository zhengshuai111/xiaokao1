package com.example.study;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderDecoration;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private Toolbar mTool;
    private RecyclerView mRv;
    private TextView mTv;

    /**
     * study
     */
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        new Thread(){
            @Override
            public void run() {
                super.run();
               Looper.prepare();
                Message message = new Message();
                message.obj = "1";
                mHandler.sendMessage(message);
               Looper.loop();
            }
        }.start();
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.tool);
        mTool.setTitle("节点导航");
        mTool.setTitleTextColor(Color.parseColor("#FFFFFF"));
        setSupportActionBar(mTool);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Bean> beans = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        ArrayList<String> arrayList5 = new ArrayList<>();
        ArrayList<String> arrayList6 = new ArrayList<>();
        ArrayList<String> arrayList7 = new ArrayList<>();
        ArrayList<String> arrayList8 = new ArrayList<>();
        ArrayList<String> arrayList9 = new ArrayList<>();
        ArrayList<String> arrayList10 = new ArrayList<>();
        ArrayList<String> arrayList11 = new ArrayList<>();
        ArrayList<String> arrayList12 = new ArrayList<>();


        arrayList.add("分享创造");
        arrayList.add("设计");
        arrayList.add("随想");
        arrayList.add("分享邀请码");
        arrayList.add("问与答");
        arrayList.add("Blog");
        arrayList.add("奇思妙想");
        arrayList.add("自言自语");


        arrayList2.add("iAd");
        arrayList2.add("iDev");
        arrayList2.add("iCode");
        arrayList2.add("iTransfer");

        arrayList3.add("奥迪");
        arrayList3.add("大众");
        arrayList3.add("随想");
        arrayList3.add("宝马");
        arrayList3.add("奔驰");
        arrayList3.add("Blog");
        arrayList3.add("奇思妙想");
        arrayList3.add("自言自语");

        arrayList4.add("分享创造");
        arrayList4.add("设计");
        arrayList4.add("随想");
        arrayList4.add("分享邀请码");
        arrayList4.add("问与答");
        arrayList4.add("Blog");
        arrayList4.add("奇思妙想");
        arrayList4.add("自言自语");


        arrayList5.add("iAd");
        arrayList5.add("iDev");
        arrayList5.add("iCode");
        arrayList5.add("iTransfer");

        arrayList6.add("奥迪");
        arrayList6.add("大众");
        arrayList6.add("随想");
        arrayList6.add("宝马");
        arrayList6.add("奔驰");
        arrayList6.add("Blog");
        arrayList6.add("奇思妙想");
        arrayList6.add("自言自语");

        arrayList7.add("分享创造");
        arrayList7.add("设计");
        arrayList7.add("随想");
        arrayList7.add("分享邀请码");
        arrayList7.add("问与答");
        arrayList7.add("Blog");
        arrayList7.add("奇思妙想");
        arrayList7.add("自言自语");


        arrayList8.add("iAd");
        arrayList8.add("iDev");
        arrayList8.add("iCode");
        arrayList8.add("iTransfer");

        arrayList9.add("奥迪");
        arrayList9.add("大众");
        arrayList9.add("随想");
        arrayList9.add("宝马");
        arrayList9.add("奔驰");
        arrayList9.add("Blog");
        arrayList9.add("奇思妙想");
        arrayList9.add("自言自语");

        arrayList10.add("分享创造");
        arrayList10.add("设计");
        arrayList10.add("随想");
        arrayList10.add("分享邀请码");
        arrayList10.add("问与答");
        arrayList10.add("Blog");
        arrayList10.add("奇思妙想");
        arrayList10.add("自言自语");


        arrayList11.add("iAd");
        arrayList11.add("iDev");
        arrayList11.add("iCode");
        arrayList11.add("iTransfer");

        arrayList12.add("奥迪");
        arrayList12.add("大众");
        arrayList12.add("随想");
        arrayList12.add("宝马");
        arrayList12.add("奔驰");
        arrayList12.add("Blog");
        arrayList12.add("奇思妙想");
        arrayList12.add("自言自语");

        beans.add(new Bean("分享与设计", arrayList));
        beans.add(new Bean("iOS", arrayList2));
        beans.add(new Bean("品牌", arrayList3));
        beans.add(new Bean("分享与设计", arrayList4));
        beans.add(new Bean("iOS", arrayList5));
        beans.add(new Bean("品牌", arrayList6));
        beans.add(new Bean("分享与设计", arrayList7));
        beans.add(new Bean("iOS", arrayList8));
        beans.add(new Bean("品牌", arrayList9));
        beans.add(new Bean("分享与设计", arrayList10));
        beans.add(new Bean("iOS", arrayList11));
        beans.add(new Bean("品牌", arrayList12));

        MyAdapter adapter = new MyAdapter(beans, this);

        StickyHeaderDecoration decoration = new StickyHeaderDecoration(adapter);

        mRv.setAdapter(adapter);
        mRv.addItemDecoration(decoration, 0);
        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url("").get().build();
        Call call = okHttpClient.newCall(request);
        try {
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

        Glide.with(getApplicationContext())
                .load("")
                .placeholder(R.drawable.color_cursor_white)
                .error(R.drawable.black_background)
                .override(300, 200)
                .fitCenter()
                .centerCrop()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .priority(Priority.HIGH)
                .into(new ImageView(this));


    }


}
