package com.hezhi.kiss.base;

import android.app.Application;

/**
 * Created by yf11 on 2017/5/2.
 */

public class MoiApplication extends Application {

    private static MoiApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler(this));

    }

    public static MoiApplication getContext() {
        return context;
    }
}
