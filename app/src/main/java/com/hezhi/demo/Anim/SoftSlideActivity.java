package com.hezhi.demo.Anim;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hezhi.codepie.R;
import com.hezhi.codepie.model.bean.LoginBean;
import com.hezhi.codepie.model.net.RequestCenter;
import com.hezhi.kiss.base.BaseActivity;
import com.hezhi.kiss.http.okhttp.response.DisposeDataListener;
import com.hezhi.kiss.interfaces.OnSoftKeyBoardListener;
import com.hezhi.kiss.utils.AnimUtil;
import com.hezhi.kiss.utils.ViewUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.hezhi.codepie.R.id.ll_root;


public class SoftSlideActivity extends BaseActivity {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.ll_login)
    LinearLayout llLogin;
    @BindView(ll_root)
    LinearLayout llRoot;
    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;


    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    //按钮底部在Y轴的坐标
    int btnY = 0;
    // 需要偏移的距离
    float delta = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_soft_slide;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        llRoot = (LinearLayout) findViewById(ll_root);
        ivLogo = (ImageView) findViewById(R.id.iv_logo);
        llLogin = (LinearLayout) findViewById(R.id.ll_login);
        // 按钮底部在Y轴的位置测量一次即可
        btnLogin.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int[] location = {0, 0};
                btnLogin.getLocationOnScreen(location);
                btnY = location[1] + btnLogin.getHeight();
                btnLogin.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });


        onGlobalLayoutListener = ViewUtil.doMonitorSoftKeyboard(llRoot, new OnSoftKeyBoardListener() {
            @Override
            public void hasShow(boolean isShow) {
                if (isShow) {
                    Rect r = new Rect();
                    llRoot.getWindowVisibleDisplayFrame(r);
                    if (getSupportActionBar() != null) {
                        delta = Math.abs(btnY - r.bottom - getSupportActionBar().getHeight());
                    } else {
                        delta = (float) Math.abs(btnY - r.bottom);
                    }
                    AnimUtil.up(llLogin, -delta);
                    AnimUtil.up(ivLogo, -delta / 2);
                } else {
                    AnimUtil.up(ivLogo, 0);
                    AnimUtil.up(llLogin, 0);

                }
            }
        });
        llRoot.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (onGlobalLayoutListener != null) {
            llRoot.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        RequestCenter.login(RequestTag, edtUsername.getText().toString(), edtPassword.getText().toString(), new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                LoginBean loginBean = (LoginBean) responseObj;

            }

            @Override
            public void onFail(Object reasonObj) {

            }
        });
    }


}
