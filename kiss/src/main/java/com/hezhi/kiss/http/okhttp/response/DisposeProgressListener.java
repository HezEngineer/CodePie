package com.hezhi.kiss.http.okhttp.response;

/**
 * Created by yf11 on 2017/5/4.
 */

public interface DisposeProgressListener extends DisposeDataListener {
    void onProgress(int progress);
}
