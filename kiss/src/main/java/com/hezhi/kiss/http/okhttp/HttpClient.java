package com.hezhi.kiss.http.okhttp;

import com.hezhi.kiss.base.MoiApplication;
import com.hezhi.kiss.http.okhttp.cookie.PersistentCookieJar;
import com.hezhi.kiss.http.okhttp.cookie.SetCookieCache;
import com.hezhi.kiss.http.okhttp.cookie.SharedPrefsCookiePersistor;
import com.hezhi.kiss.http.okhttp.response.DisposeDataHandle;
import com.hezhi.kiss.http.okhttp.response.FileCallback;
import com.hezhi.kiss.http.okhttp.response.JsonCallback;
import com.hezhi.kiss.utils.HttpsUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by yf11 on 2017/4/27.
 */

public class HttpClient {

    public static OkHttpClient httpClient;

    static {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        /***  为请求添加请求头
         *  User-Agent  : "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)"
         *
         */
        clientBuilder.addInterceptor(new LogInterceptor());
        clientBuilder.connectTimeout(HttpsUtils.TIME_OUT, TimeUnit.SECONDS);
        clientBuilder.writeTimeout(HttpsUtils.TIME_OUT, TimeUnit.SECONDS);
        clientBuilder.readTimeout(HttpsUtils.TIME_OUT, TimeUnit.SECONDS);
        clientBuilder.cookieJar(new PersistentCookieJar(new SetCookieCache(),new SharedPrefsCookiePersistor(MoiApplication.getContext())));
        clientBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(),HttpsUtils.initTrustManager());
        clientBuilder.followSslRedirects(true);
        clientBuilder.followRedirects(true);
        httpClient = clientBuilder.build();
    }

    public static OkHttpClient getHttpClient() {
        return httpClient;
    }


    /**
     * @param tag 取消指定标记请求
     */
    public static void cancel(String tag) {
        for (Call call : httpClient.dispatcher().queuedCalls()) {
            if (tag.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call : httpClient.dispatcher().runningCalls()) {
            if (tag.equals(call.request().tag())) {
                call.cancel();
            }
        }
    }


    /**
     * get请求加入队列,
     * @param request {@link com.hezhi.kiss.http.okhttp.request.CommonRequest} 创建的get请求
     * @param handle 统一处理的句柄
     * @return
     */
    public static Call get(Request request, DisposeDataHandle handle){
        Call call = httpClient.newCall(request);
        call.enqueue(new JsonCallback(handle));
        return call;
    }

    /**
     * post请求入队列
     * @param request
     * @param handle
     * @return
     */
    public static Call post(Request request,DisposeDataHandle handle) {
        Call call = httpClient.newCall(request);
        call.enqueue(new JsonCallback(handle));
        return call;
    }

    /**
     * post 上传文件
     * @param request
     * @param handle
     * @return
     */
    public static Call postFile(Request request,DisposeDataHandle handle) {
        Call call = httpClient.newCall(request);
        call.enqueue(new FileCallback(handle));
        return call;
    }
}
