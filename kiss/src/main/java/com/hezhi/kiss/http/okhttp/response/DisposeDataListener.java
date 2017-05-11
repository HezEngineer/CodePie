package com.hezhi.kiss.http.okhttp.response;

/**
 * Created by yf11 on 2017/4/27.
 */

public interface DisposeDataListener {
    /**
     * 请求成功回调事件处理
     */
    public void onSuccess(Object responseObj);

    /**
     * 请求失败回调事件处理
     */
    public void onFail(Object reasonObj);
}
