package com.hezhi.gank.ui.gank.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.hezhi.gank.R;
import com.hezhi.gank.common.constant.Constant;
import com.hezhi.kiss.base.BaseSimpleActivity;

import butterknife.BindView;

/**
 * Created by yf11 on 2017/6/26.
 */

public class ArticleDetailActivity extends BaseSimpleActivity {

    @BindView(R.id.tbTopBar)
    Toolbar tbTopBar;
    @BindView(R.id.wvContent)
    WebView wvContent;

    private String detailUrl ;

    @Override
    protected int getLayoutId() {
        return R.layout.detail_article_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailUrl = getIntent().getStringExtra(Constant.DETAIL_URL);
        wvContent.loadUrl(detailUrl);
    }
}
