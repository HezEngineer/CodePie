package com.hezhi.kiss.base;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by yf11 on 2017/6/15.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected T view;

    protected Retrofit retrofit;

    public BasePresenterImpl (){}

    @Inject
    public BasePresenterImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
            this.view = null;
    }
}
