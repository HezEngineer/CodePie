package com.hezhi.gank.ui.gank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hezhi.gank.R;
import com.hezhi.gank.common.constant.Constant;
import com.hezhi.gank.model.bean.GankItemBean;
import com.hezhi.gank.presenter.contract.GirConract;
import com.hezhi.gank.presenter.impl.GrilPresenterImpl;
import com.hezhi.gank.ui.gank.adapter.GirlAdapter;
import com.hezhi.kiss.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import retrofit2.Retrofit;

/**
 * Created by yf11 on 2017/6/29.
 */

public class GirlFragment extends BaseMvpFragment<GrilPresenterImpl> implements GirConract.View {

    @BindView(R.id.rv_Android)
    RecyclerView rvAndroid;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout srlRefresh;

    @Inject
    Retrofit retrofit;

    List<GankItemBean> grilList;

    String type ;
    GirlAdapter girlAdapter;

    public static GirlFragment newInstance(String title, String type) {
        GirlFragment girlFragment = new GirlFragment();
        Bundle args = new Bundle();
        args.putString(Constant.TITLE, title);
        args.putString(Constant.TYPE, type);
        girlFragment.setArguments(args);
        return girlFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_android;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new GrilPresenterImpl(retrofit);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        type = getArguments().getString(Constant.TYPE);
        grilList = new ArrayList<>();
        girlAdapter= new GirlAdapter(getActivity(),grilList);
        srlRefresh.setRefreshing(true);
        rvAndroid.setLayoutManager(new GridLayoutManager(getActivity(),1));
        rvAndroid.setAdapter(girlAdapter);
        presenter.getGirls(Constant.TYPE_GRIL);
        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getGirls(Constant.TYPE_GRIL);
            }
        });
    }

    @Override
    public void showGirls(List<GankItemBean> list) {
        if(srlRefresh.isRefreshing()) {
            srlRefresh.setRefreshing(false);
        }
        grilList.addAll(list);
        girlAdapter.notifyDataSetChanged();

    }
}
