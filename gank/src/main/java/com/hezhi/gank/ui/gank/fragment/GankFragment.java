package com.hezhi.gank.ui.gank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.hezhi.gank.R;
import com.hezhi.gank.common.constant.Constant;
import com.hezhi.gank.ui.gank.adapter.FragmentAdapter;
import com.hezhi.gank.widget.MulViewPager;
import com.hezhi.kiss.base.BaseSimpleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yf11 on 2017/5/19.
 */

public class GankFragment extends BaseSimpleFragment {


    @BindView(R.id.tlGank)
    TabLayout tlGank;
    @BindView(R.id.vpGank)
    MulViewPager vpGank;

    List<Fragment> fragments = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragments = new ArrayList<>();
        fragments.add(AndroidFragment.newInstance(Constant.TYPE_ANDROID,Constant.TYPE_ANDROID));
        fragments.add(AndroidFragment.newInstance(Constant.TYPE_IOS,Constant.TYPE_IOS));
        fragments.add(AndroidFragment.newInstance(Constant.TYPE_FRONTEND,Constant.TYPE_FRONTEND));
        fragments.add(GirlFragment.newInstance(Constant.TYPE_GRIL,Constant.TYPE_FRONTEND));
        vpGank.setAdapter(new FragmentAdapter(getChildFragmentManager(),fragments));
        tlGank.addTab(tlGank.newTab());
        tlGank.addTab(tlGank.newTab());
        tlGank.addTab(tlGank.newTab());
        tlGank.setupWithViewPager(vpGank);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
