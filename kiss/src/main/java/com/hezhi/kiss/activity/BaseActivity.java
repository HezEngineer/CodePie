package com.hezhi.kiss.activity;

import android.content.Context;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by yf11 on 2017/4/19.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN) {
            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View v = getCurrentFocus();
            if(shouldHideSoftKeyboard(v,ev)) {
                hideSoftKeyboard(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 隐藏软键盘
     * */
    private void hideSoftKeyboard(IBinder windowToken) {
        if(windowToken != null) {
            InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            in.hideSoftInputFromWindow(windowToken,InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
     * @param v 当前获取焦点的view
     * @param ev 触摸事件
     */
    private boolean shouldHideSoftKeyboard(View v, MotionEvent ev) {
        if(v != null && v instanceof EditText) {
            // 点击EditText
            int[] outLocation = {0,0};
            v.getLocationInWindow(outLocation);
            int left = outLocation[0];
            int top = outLocation[1];
            int right = left + v.getWidth();
            int bottom = top + v.getHeight();
            if(ev.getX() > left && ev.getX() < right && ev.getY() > top && ev.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }
}
