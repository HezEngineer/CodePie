package com.hezhi.kiss.http.okhttp.request;

import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yf11 on 2017/4/26.
 */

public class RequesFileParam {
    public ConcurrentHashMap<String, Object> fileParams = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, Object>  getFileParams() {
        return fileParams;
    }

    public RequesFileParam(){

    }

    public void put(String key,Object value) throws FileNotFoundException{
        if(key != null) {
            fileParams.put(key,value);
        }
    }

    public boolean hasParam() {
        if(fileParams.size()>0) {
            return true;
        }
        return false;
    }
}
