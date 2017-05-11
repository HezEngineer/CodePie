package com.hezhi.kiss.http.okhttp.response;

/**
 * Created by yf11 on 2017/4/27.
 */

public class DisposeDataHandle {

    public DisposeDataListener listener;
    public DisposeProgressListener progressListener;
    public String filePath;
    public Class<?> clazz ;

    public DisposeDataHandle(DisposeDataListener listener, Class<?> clazz) {
        this.listener = listener;
        this.clazz = clazz;
    }

    public DisposeDataHandle(DisposeProgressListener listener, String filePath){
        this.progressListener = listener;
        this.filePath = filePath;
    }
}
