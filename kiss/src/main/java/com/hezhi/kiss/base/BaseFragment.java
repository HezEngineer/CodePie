package com.hezhi.kiss.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.hezhi.kiss.http.okhttp.HttpClient;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yf11 on 2017/5/9.
 */

public class BaseFragment extends Fragment {
    protected String RequestTag = getClass().getSimpleName();
    private Unbinder unbinder;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this,view);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        HttpClient.cancel(RequestTag);
    }


    /**
     * 网络请求写在这里
     * */
    public void refresh() {

    }

}
