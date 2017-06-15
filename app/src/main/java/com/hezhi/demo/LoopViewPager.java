package com.hezhi.demo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by yf11 on 2017/6/9.
 */

public class LoopViewPager extends ViewPager {
    public void setAutoRefresh(boolean autoRefresh) {
        isAutoRefresh = autoRefresh;
    }

    public boolean isAutoRefresh() {
        return isAutoRefresh;
    }

    private boolean isAutoRefresh = true;

    public LoopViewPager(Context context) {
        super(context);
    }

    public LoopViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isAutoRefresh = false;
                break;
            case MotionEvent.ACTION_MOVE:
                isAutoRefresh = false;
                break;
            case MotionEvent.ACTION_UP:
                isAutoRefresh = true;
                break;
        }
        return super.onTouchEvent(ev);
    }
}
