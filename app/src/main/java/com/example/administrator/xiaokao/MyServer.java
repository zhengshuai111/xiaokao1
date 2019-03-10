package com.example.administrator.xiaokao;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/12/29.
 */

public interface MyServer {

    //http://news-at.zhihu.com/api/4/news/hot

    String URL = "http://news-at.zhihu.com/api/4/";
    @GET("news/hot")
    Observable<Bean> getData();
}
