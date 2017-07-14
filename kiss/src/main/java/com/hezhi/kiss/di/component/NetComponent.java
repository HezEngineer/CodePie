package com.hezhi.kiss.di.component;


import com.hezhi.kiss.di.module.AppModule;
import com.hezhi.kiss.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by yf11 on 2017/7/11.
 * dagger2 注入{@link https://adityaladwa.wordpress.com/2016/05/11/dagger-2-and-mvp-architecture/}
 *
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit retrofit();
}
