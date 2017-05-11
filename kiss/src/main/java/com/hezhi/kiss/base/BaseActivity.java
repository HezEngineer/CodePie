package com.hezhi.kiss.base;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.hezhi.kiss.Manager.activity.ActivityInfo;
import com.hezhi.kiss.Manager.activity.ActivityManager;
import com.hezhi.kiss.http.okhttp.HttpClient;
import com.hezhi.kiss.utils.PermissionUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yf11 on 2017/4/19.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected String RequestTag = getClass().getSimpleName();
    private Unbinder unbinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this);
        ActivityManager.addNewActivity(new ActivityInfo(RequestTag,this));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionUtil.Constant.CAMERA_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    doOpenCamera();
                }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        HttpClient.cancel(RequestTag);
    }

    @Override
    public void onBackPressed() {
        popUpActivity();
    }

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
     * 网络请求写在这里
     * */
    public void refresh() {

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


    public void popUpActivity() {
        popUpActivity(false);
    }

    /**
     * @param isrefresh
     */
    public void popUpActivity(boolean isrefresh) {
        ActivityManager.popActivity(isrefresh);
    }

    /**
     * @param id
     * @param isrefresh
     */
    public void popUpActivity(String id, boolean isrefresh) {
        ActivityManager.popToActivityById(id, isrefresh);
    }

    protected void doOpenCamera(){};
}
