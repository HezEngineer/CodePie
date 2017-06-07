package com.hezhi.demo;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by yf11 on 2017/6/7.
 */

public class ViewPagerBanner extends ViewPager {

    public ViewPagerBanner(Context context) {
        this(context,null);

    }

    public ViewPagerBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {

    }
}
