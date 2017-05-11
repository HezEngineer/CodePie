package com.hezhi.kiss.http.okhttp.request;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yf11 on 2017/4/26.
 */

public class RequestParam {
    private  ConcurrentHashMap<String,String> params = new ConcurrentHashMap<>();

    public RequestParam(){

    }

    public void put(String key,String value) {
        if(key != null && value != null) {
            params.put(key,value);
        }
    }

    public boolean hasParams() {

        if(params.size() > 0 ) {
            return true;
        }
        return false;
    }

    public ConcurrentHashMap<String, String> getParams() {
        return params;
    }

    public void setParams(ConcurrentHashMap<String, String> params) {
        this.params = params;
    }
}
