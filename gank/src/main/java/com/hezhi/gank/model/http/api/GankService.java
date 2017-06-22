package com.hezhi.gank.model.http.api;

import com.hezhi.gank.BuildConfig;
import com.hezhi.gank.model.bean.GankItemBean;
import com.hezhi.gank.model.http.response.GankReponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yf11 on 2017/6/15.
 */

public interface GankService {

    String rootUrl = BuildConfig.http+BuildConfig.serverAddress;

    @GET("data/{type}/{num}/{page}")
    Call<GankReponse<List<GankItemBean>>> getData(@Path("type") String type, @Path("num") int mum, @Path("page") int page);
}
