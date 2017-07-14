package com.hezhi.kiss.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by yf11 on 2017/5/9.
 * 有mvp的Activity基类
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity {
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
