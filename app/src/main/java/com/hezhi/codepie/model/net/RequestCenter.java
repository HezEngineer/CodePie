package com.hezhi.codepie.model.net;

import com.hezhi.codepie.model.bean.LoginBean;
import com.hezhi.kiss.http.okhttp.HttpClient;
import com.hezhi.kiss.http.okhttp.request.CommonRequest;
import com.hezhi.kiss.http.okhttp.request.RequestParam;
import com.hezhi.kiss.http.okhttp.response.DisposeDataHandle;
import com.hezhi.kiss.http.okhttp.response.DisposeDataListener;

/**
 * Created by yf11 on 2017/5/2.
 */

public class RequestCenter {

    public static void getRequest(String tag,String url, RequestParam params, DisposeDataListener listener, Class<?> clazz) {
        HttpClient.get(CommonRequest.createGetRequest(tag,url,params),new DisposeDataHandle(listener,clazz));
    }

    public static void postRequest(String tag,String url, RequestParam params, DisposeDataListener listener, Class<?> clazz) {
        HttpClient.post(CommonRequest.createPostRequest(tag,url,params),new DisposeDataHandle(listener,clazz));

    }

    public static void login(String tag,String u,String p,DisposeDataListener listener) {
        RequestParam params = new RequestParam();
        params.put("j_username", u);
        params.put("j_password", p);
        postRequest(tag,HttpConstatns.LOGIN,params,listener, LoginBean.class);
    }

    public static void achievement(String tag,String seid,DisposeDataListener listener) {
        RequestParam params = new RequestParam();
        params.put("seID",seid);
        getRequest(tag,HttpConstatns.ACHEIVEMENTSS,params,listener,null);
    }

}
