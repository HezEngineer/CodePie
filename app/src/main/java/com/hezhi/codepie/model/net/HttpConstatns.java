package com.hezhi.codepie.model.net;

import com.hezhi.codepie.BuildConfig;

/**
 * Created by yf11 on 2017/5/2.
 */

public class HttpConstatns {


    public static String Http_http = BuildConfig.HttpName;
    /**
     * 服务器地址
     * */
    public static String Http_address = BuildConfig.HttpAdderss;

    // TODO: 2017/5/2
    public static final String ROOT_URL = Http_http + Http_address;

    /**
     * 登录
     */
    public final static String LOGIN = ROOT_URL + "/phone/SystemLogin";

    /**
     * 请求一次成绩单服务器地址
     * https://out.wish80.com:9115/ytw-web/phone/cj/order.shtml?seID=16947
     *  https://out.wish80.com:9115/ytw-web/phone/cj/subject-list.shtml?seID=16947
     * */

    public final static String ACHEIVEMENTSS = ROOT_URL + "/phone/cj/order.shtml";
}
