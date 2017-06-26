package com.hezhi.gank.ui.gank.fragment;


import android.os.Bundle;

import com.hezhi.gank.R;
import com.hezhi.gank.common.constant.Constant;
import com.hezhi.kiss.base.BaseSimpleFragment;


public class IOSFragment extends BaseSimpleFragment {

    public static IOSFragment newInstance(String title) {
        IOSFragment iOSFragment = new IOSFragment();
        Bundle args = new Bundle();
        args.putString(Constant.TITLE,title);
        iOSFragment.setArguments(args);
        return iOSFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_io;
    }
}
