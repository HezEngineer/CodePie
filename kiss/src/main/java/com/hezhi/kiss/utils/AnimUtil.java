package com.hezhi.kiss.utils;

import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by yf11 on 2017/4/20.
 */

public class AnimUtil {

    public static void up(View v,float delta) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(v,"translationY",delta);
        animator.setDuration(250);
        animator.start();
    }
}
