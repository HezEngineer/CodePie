package com.hezhi.codepie;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hezhi.kiss.activity.BaseActivity;
import com.hezhi.kiss.interfaces.OnSoftKeyBoardListener;
import com.hezhi.kiss.utils.AnimUtil;
import com.hezhi.kiss.utils.ViewUtil;


public class SoftSlideActivity extends BaseActivity {

    private LinearLayout ll_root;
    private ImageView iv_logo;
    private EditText edt_username;
    private Button btn_login;
    private LinearLayout ll_login;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener ;
    //按钮底部在Y轴的坐标
    int btnY = 0;
    // 需要偏移的距离
    float delta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_slide);
        ll_root = (LinearLayout) findViewById(R.id.ll_root);
        iv_logo = (ImageView) findViewById(R.id.iv_logo);
        edt_username = (EditText) findViewById(R.id.edt_username);
        btn_login = (Button) findViewById(R.id.btn_login);
        ll_login = (LinearLayout) findViewById(R.id.ll_login);
        // 按钮底部在Y轴的位置测量一次即可
        btn_login.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int[] location = {0,0};
                btn_login.getLocationOnScreen(location);
                btnY = location[1]+btn_login.getHeight();
                btn_login.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });


        onGlobalLayoutListener = ViewUtil.doMonitorSoftKeyboard(ll_root, new OnSoftKeyBoardListener() {
            @Override
            public void hasShow(boolean isShow) {
                if(isShow) {
                    Rect r = new Rect();
                    ll_root.getWindowVisibleDisplayFrame(r);
                    if(getSupportActionBar()!= null ) {
                        delta = Math.abs(btnY-r.bottom-getSupportActionBar().getHeight());
                    } else {
                        delta =  (float) Math.abs(btnY-r.bottom);
                    }
                    AnimUtil.up(ll_login,-delta);
                    AnimUtil.up(iv_logo,-delta/2);
                } else {
                    AnimUtil.up(iv_logo,0);
                    AnimUtil.up(ll_login,0);

                }
            }
        });
        ll_root.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(onGlobalLayoutListener != null) {
            ll_root.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }
}
