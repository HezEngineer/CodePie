package com.hezhi.kiss.http.okhttp;

import com.hezhi.kiss.utils.LogUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yf11 on 2017/4/28.
 */

public class LogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        LogUtil.i(this,String.format("Sending request %s on %s%n header ---%s",
                request.url(), chain.connection(), request.headers()));
        Response response = chain.proceed(request);
        return response;
    }
}
