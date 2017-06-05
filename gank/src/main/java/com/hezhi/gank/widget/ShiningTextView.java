package com.hezhi.gank.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;

/**
 * Created by yf11 on 2017/5/23.
 */

public class ShiningTextView extends AppCompatTextView {
    int width =0;
    Float translateX =0F;
    Paint paint;
    LinearGradient linearGradient;
    Matrix matrix ;
    ValueAnimator animator;
    public ShiningTextView(Context context) {
        super(context);
    }

    public ShiningTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShiningTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(width == 0) {
            width = getMeasuredWidth();
            if(width > 0) {
                paint = getPaint();
                linearGradient = new LinearGradient(0,0,width,0 ,new int[]{Color.BLUE,0xffffffff,Color.BLUE},
                        null, Shader.TileMode.CLAMP);
                paint.setShader(linearGradient);
                matrix = new Matrix();
                animator = ObjectAnimator.ofFloat(this,"empty",0f,getMeasuredWidth()+100);
                animator.setDuration(250l);
                animator.setInterpolator(new LinearInterpolator());
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        count ++;
                        result = (float)animation.getAnimatedValue()-last;
                        System.out.println("=== count : "+count+"   result = "+result);
                        last = (float)animation.getAnimatedValue();
                        translateX  = (float)animation.getAnimatedValue();
                        invalidate();
                    }
                });
                animator.start();
                animator.setRepeatCount(10);

            }
        }
    }

    float last = 0;
    float result = 0;
    int count = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(matrix != null) {
            matrix.setTranslate(translateX,0);
            linearGradient.setLocalMatrix(matrix);
        }
    }
}
