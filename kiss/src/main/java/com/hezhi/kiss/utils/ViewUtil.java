package com.hezhi.kiss.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

import com.hezhi.kiss.interfaces.OnSoftKeyBoardListener;

/**
 * Created by yf11 on 2017/4/20.
 * 布局与视图相关操作的工具类
 */

public class ViewUtil {

    /***
     * 判断软件盘是否弹出
     * @param v
     * @param listener
     * 备注：在不用的时候记得移除OnGlobalLayoutListener
     * */
    public static ViewTreeObserver.OnGlobalLayoutListener doMonitorSoftKeyboard(final View v,final OnSoftKeyBoardListener listener) {
        final ViewTreeObserver.OnGlobalLayoutListener layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                v.getWindowVisibleDisplayFrame(r);
                int screenHeight = v.getRootView().getHeight();
                int heightDifference = screenHeight-r.bottom;
                boolean isSoftVisible = heightDifference > (screenHeight / 3);
                if(listener != null) {
                    listener.hasShow(isSoftVisible);
                }
            }
        };
        v.getViewTreeObserver().addOnGlobalLayoutListener(layoutListener);
        return layoutListener;
    }
}
