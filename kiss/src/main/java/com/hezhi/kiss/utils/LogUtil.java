package com.hezhi.kiss.utils;

import android.util.Log;

/**
 * Created by yf11 on 2017/4/27.
 */

public class LogUtil {

    public static String TAG = "debug";
    /**
     * 日志开关
     * false 表示关闭日志 ture表示开启日志
     */
    private static boolean isLog = true;

    public static void i(Object object, String msg) {
        if (isLog == true) {
            Log.i(TAG, "==== " + object.getClass().getName() + "--------" + msg);
        }
    }

    public static void i(String msg) {
        if (isLog == true) {
            Log.i(TAG, "======   " + msg);
        }
    }

}
