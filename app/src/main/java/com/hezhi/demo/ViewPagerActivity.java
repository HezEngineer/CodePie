package com.hezhi.demo;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.hezhi.codepie.R;
import com.hezhi.kiss.base.BaseSimpleActivity;

import butterknife.BindView;

public class ViewPagerActivity extends BaseSimpleActivity {


    public static final int LOOP = 1000;

    @BindView(R.id.vp_loop)
    ViewPager vpLoop;
    @BindView(R.id.ll_dots)
    LinearLayout llDots;


    int currentIndex = 1;

    int size = 5;

    public Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case LOOP:
                    currentIndex ++;
                    System.out.println("=====currentIndex = [" + currentIndex + "]");
                    currentIndex = currentIndex % size;
                    vpLoop.setCurrentItem(currentIndex);
                    sendEmptyMessageDelayed(LOOP,3000);
                    break;
            }
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_pager;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdsPagerAdapter adsPagerAdapter = new AdsPagerAdapter(this);
        vpLoop.setAdapter(adsPagerAdapter);
        vpLoop.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                System.out.println("====position = [" + position + "]");
                if(currentIndex != position) {
                    currentIndex = position;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        handler.sendEmptyMessageDelayed(LOOP,3000);
    }


    class AdsPagerAdapter extends PagerAdapter {
        private String[] imageUrls = {"http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg",
                "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
                "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
                "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
                "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg"};
        private Context context;
        private LayoutInflater inflater;
        public AdsPagerAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate(R.layout.layout_ads_item,container,false);
            ImageView iv_ad = (ImageView) view.findViewById(R.id.iv_ad);
            Glide.with(context).load(imageUrls[position])
                    .asBitmap()
                    .placeholder(context.getResources().getDrawable(R.mipmap.ic_launcher))
                    .into(iv_ad);
            container.addView(view);
            return  view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getCount() {
            return imageUrls.length;
        }
    }
}
