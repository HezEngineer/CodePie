package com.hezhi.kiss.base;

/**
 * Created by yf11 on 2017/5/8.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
