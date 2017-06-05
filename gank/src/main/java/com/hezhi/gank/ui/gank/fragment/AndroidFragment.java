package com.hezhi.gank.ui.gank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hezhi.gank.R;
import com.hezhi.kiss.base.BaseSimpleFragment;

import butterknife.BindView;


public class AndroidFragment extends BaseSimpleFragment {


    @BindView(R.id.tvScroll)
    TextView tvScroll;


    public static AndroidFragment newInstance(String title) {
        AndroidFragment androidFragment = new AndroidFragment();
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        androidFragment.setArguments(args);
        return androidFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_android;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}
