package com.hezhi.kiss.base;

import android.app.Application;

import com.hezhi.kiss.di.component.DaggerNetComponent;
import com.hezhi.kiss.di.component.NetComponent;
import com.hezhi.kiss.di.module.AppModule;
import com.hezhi.kiss.di.module.NetModule;


/**
 * Created by yf11 on 2017/5/2.
 */

public class App extends Application {

    private static App context;

    public static NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler(this));

    }

    public static synchronized App getContext() {
        return context;
    }

    public static NetComponent getNetComponent() {
        if (netComponent == null){
            netComponent = DaggerNetComponent.builder()
                    .netModule(new NetModule())
                    .appModule(new AppModule(context))
                    .build();
        }
        return netComponent;
    }
}
