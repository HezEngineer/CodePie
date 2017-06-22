package com.hezhi.gank.ui.gank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hezhi.gank.R;
import com.hezhi.gank.model.bean.GankItemBean;
import com.hezhi.gank.presenter.contract.AndroidContract;
import com.hezhi.gank.presenter.impl.AndroidPresenterImpl;
import com.hezhi.gank.ui.gank.adapter.AndroidAdapter;
import com.hezhi.kiss.base.BaseMvpFragment;

import java.util.List;

import butterknife.BindView;


public class AndroidFragment extends BaseMvpFragment<AndroidPresenterImpl> implements AndroidContract.View {


    @BindView(R.id.rvAndroid)
    RecyclerView rvAndroid;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new AndroidPresenterImpl();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getAndroidData();

    }

    @Override
    public void showData(List<GankItemBean> list) {
        rvAndroid.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAndroid.setAdapter(new AndroidAdapter(list,getActivity()));

    }
}
