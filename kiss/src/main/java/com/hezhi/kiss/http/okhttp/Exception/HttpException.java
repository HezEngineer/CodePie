package com.hezhi.kiss.http.okhttp.Exception;

/**
 * Created by yf11 on 2017/4/27.
 */

public class HttpException extends Exception {
    /**
     * 服务器定义的错误返回码
     * */
    private String ecode;
    /**
     * 服务器定义的错误返回信息
     * */
    private Object emsg;

    public HttpException( String ecode, Object emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public String getEcode() {
        return ecode;
    }

    public Object getEmsg() {
        return emsg;
    }
}
