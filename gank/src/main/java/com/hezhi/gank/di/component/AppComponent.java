package com.hezhi.gank.di.component;

import com.hezhi.gank.model.http.api.GankService;

import dagger.Component;

/**
 * Created by yf11 on 2017/6/28.
 */
@Component
public interface AppComponent {

    GankService injectService();

}
