package com.hezhi.kiss.di.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hezhi.kiss.BuildConfig;
import com.hezhi.kiss.base.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yf11 on 2017/7/11.
 */
@Module
public class NetModule {
    public NetModule() {
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(App app) {
        return PreferenceManager.getDefaultSharedPreferences( app);
    }

    @Provides  @Singleton
    Cache provideHttpCache(App app) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(app.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        //todo 服务器地址更换
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.http+BuildConfig.serverAddress)
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
