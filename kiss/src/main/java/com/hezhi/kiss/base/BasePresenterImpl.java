package com.hezhi.kiss.base;

/**
 * Created by yf11 on 2017/6/15.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
            this.view = null;
    }
}
