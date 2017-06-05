package com.hezhi.gank.ui.gank.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hezhi.kiss.base.BaseFragment;

import java.util.List;

/**
 * Created by yf11 on 2017/5/22.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments ;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
    * when TabLayout work with ViewPager, the title are disappear, so
     * we override this method to solve this;
    * */

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getArguments().get(BaseFragment.TITLE).toString();
    }
}
