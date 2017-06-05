package com.hezhi.gank.ui.gank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.hezhi.gank.R;
import com.hezhi.gank.ui.gank.adapter.FragmentAdapter;
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
    ViewPager vpGank;

    List<Fragment> fragments = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragments = new ArrayList<>();
        fragments.add(AndroidFragment.newInstance("Android"));
        fragments.add(IOSFragment.newInstance("IOS"));
        fragments.add(FrontFragment.newInstance("前端"));
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
