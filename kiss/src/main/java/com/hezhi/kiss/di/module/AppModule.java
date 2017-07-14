package com.hezhi.kiss.di.module;

import com.hezhi.kiss.base.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yf11 on 2017/7/11.
 */
@Module
public class AppModule {

    App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    App provideApp(){
        return app;
    }
}
