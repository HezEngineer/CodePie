package com.hezhi.gank.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.hezhi.gank.R;
import com.hezhi.gank.ui.gank.fragment.GankFragment;
import com.hezhi.gank.ui.gank.fragment.MeFragment;
import com.hezhi.gank.widget.MulViewPager;
import com.hezhi.kiss.base.BaseSimpleActivity;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseSimpleActivity {

    @BindView(R.id.vpMain)
    MulViewPager vpMain;
    @BindView(R.id.bnvMain)
    BottomNavigationView bnvMain;

    ArrayList<Fragment> fragments;

    MenuItem prevMenuItem;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    ViewPager.OnPageChangeListener pageChangeListener;

    GankFragment gankFragment;
    MeFragment meFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#375683"));
        }

        bnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_gank) {
                    vpMain.setCurrentItem(0);
                } else if (item.getItemId() == R.id.item_me) {
                    vpMain.setCurrentItem(1);
                }
                return false;
            }
        });
        pageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else {
                    bnvMain.getMenu().getItem(0).setChecked(false);
                }

                bnvMain.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bnvMain.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        gankFragment = new GankFragment();
        meFragment = new MeFragment();
        fragments = new ArrayList<>();
        fragments.add(gankFragment);
        fragments.add(meFragment);
        vpMain.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        vpMain.addOnPageChangeListener(pageChangeListener);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vpMain.removeOnPageChangeListener(pageChangeListener);
    }
}
