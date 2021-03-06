package com.hezhi.gank.presenter.impl;

import com.hezhi.gank.model.bean.GankItemBean;
import com.hezhi.gank.model.http.api.GankService;
import com.hezhi.gank.model.http.response.GankReponse;
import com.hezhi.gank.presenter.contract.AndroidContract;
import com.hezhi.kiss.base.BasePresenterImpl;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by yf11 on 2017/6/15.
 */

public class AndroidPresenterImpl extends BasePresenterImpl<AndroidContract.View> implements AndroidContract.Presenter{
    public static final int NUM_OF_PAGE = 20;

    private int curPage = 1;

    public AndroidPresenterImpl( Retrofit retrofit1) {
        super(retrofit1);
    }

    @Override
    public void getData(String type) {

        //todo use dagger to inject Rerofit
        GankService gankService = retrofit.create(GankService.class);
        Call<GankReponse<List<GankItemBean>>> call =  gankService.getData(type,NUM_OF_PAGE,curPage);
        call.enqueue(new Callback<GankReponse<List<GankItemBean>>>() {
            @Override
            public void onResponse(Call<GankReponse<List<GankItemBean>>> call, Response<GankReponse<List<GankItemBean>>> response) {
                List<GankItemBean> gankItemBeans = response.body().getResults();
                view.showData(gankItemBeans);
            }

            @Override
            public void onFailure(Call<GankReponse<List<GankItemBean>>> call, Throwable throwable) {

            }
        });
    }

    @Override
    public void getMoreData(String type) {
        //todo use dagger to inject Retrofit
        GankService gankService = retrofit.create(GankService.class);
        Call<GankReponse<List<GankItemBean>>> call =  gankService.getData(type,NUM_OF_PAGE,++curPage);
        call.enqueue(new Callback<GankReponse<List<GankItemBean>>>() {
            @Override
            public void onResponse(Call<GankReponse<List<GankItemBean>>> call, Response<GankReponse<List<GankItemBean>>> response) {
                List<GankItemBean> gankItemBeans = response.body().getResults();
                view.showMoreData(gankItemBeans);
            }

            @Override
            public void onFailure(Call<GankReponse<List<GankItemBean>>> call, Throwable throwable) {

            }
        });
    }
}
