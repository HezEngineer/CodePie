package com.hezhi.kiss.http.okhttp.response;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.hezhi.kiss.http.okhttp.Exception.HttpException;
import com.hezhi.kiss.utils.LogUtil;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

/**
 * Created by yf11 on 2017/4/27.
 */

public class JsonCallback implements Callback {

    public final String RESULT_CODE = "result";
    public final String ERROR_MSG = "emsg";

    //错误信息
    public final String ERROR_EMPTY = "";

    //错误码
    public final String NET_ERROR = "-1";
    public final String JSON_ERROR = "-2";
    public final String OTHER_ERROR = "-3";


    private DisposeDataListener listener;
    private Class<?> clazz ;
    private Handler deliveryHandler;

    public JsonCallback(DisposeDataHandle handle) {
        this.listener = handle.listener;
        this.clazz = handle.clazz;
        this.deliveryHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        deliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                listener.onFail(new HttpException(NET_ERROR,e));
            }
        });
    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        final String  result = response.body().string();
        LogUtil.i(this,response.request().url() + "\n" + response.headers().toString()+"\n"+result);
        deliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });

    }

    private void handleCookie(Headers headers) {

    }

    private void handleResponse(final Object result) {
        if (result == null || result.toString().trim().equals("")) {
            listener.onFail(new HttpException(NET_ERROR, ERROR_EMPTY));
            return;
        }

        try {
            JSONObject jsonObject = new JSONObject(result.toString());

            // TODO: 2017/4/27
            //获取服务器返回码处理
            String ecode = jsonObject.optString(RESULT_CODE);
            if (NET_ERROR.equals(ecode)) {
                listener.onFail(new HttpException(NET_ERROR, ERROR_EMPTY));
            } else if (OTHER_ERROR.equals(ecode)) {
                listener.onFail(new HttpException(OTHER_ERROR, ERROR_EMPTY));
            } else {
                if (clazz == null) {
                    listener.onSuccess(jsonObject);
                } else {
                    Object obj = new Gson().fromJson(jsonObject.toString(),clazz);
                    if (obj != null) {
                        listener.onSuccess(obj);
                    } else {
                        listener.onFail(new HttpException(JSON_ERROR, ERROR_EMPTY));
                    }
                }

            }
        } catch (Exception e) {
            listener.onFail(new HttpException(OTHER_ERROR,ERROR_EMPTY));
            e.printStackTrace();
        }
    }
}
