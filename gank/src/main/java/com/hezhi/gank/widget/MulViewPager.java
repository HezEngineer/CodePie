package com.hezhi.gank.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * Created by yf11 on 2017/5/19.
 */

public class MulViewPager extends ViewPager {

    public MulViewPager(Context context) {
        super(context);
    }

    public MulViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        float lastx = 0F;
        float curX = 0F;
        int touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastx = ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                curX = ev.getX();
                float delta = curX - lastx;
                int curItemPos = getCurrentItem();
                int totalNum = getAdapter().getCount();
                if(curItemPos == totalNum-1) {
                    if(delta > 0 && delta > touchSlop) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


}
