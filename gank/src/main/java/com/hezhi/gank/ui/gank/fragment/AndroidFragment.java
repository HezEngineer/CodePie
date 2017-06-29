package com.hezhi.gank.ui.gank.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hezhi.gank.R;
import com.hezhi.gank.common.constant.Constant;
import com.hezhi.gank.model.bean.GankItemBean;
import com.hezhi.gank.presenter.contract.AndroidContract;
import com.hezhi.gank.presenter.impl.AndroidPresenterImpl;
import com.hezhi.gank.ui.gank.activity.ArticleDetailActivity;
import com.hezhi.gank.ui.gank.adapter.AndroidAdapter;
import com.hezhi.kiss.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class AndroidFragment extends BaseMvpFragment<AndroidPresenterImpl> implements AndroidContract.View {


    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout srlRefresh;

    @BindView(R.id.rv_Android)
    RecyclerView rvAndroid;

    List<GankItemBean> mList;
    AndroidAdapter adapter;

    String type;


    public static AndroidFragment newInstance(String title, String type) {
        AndroidFragment androidFragment = new AndroidFragment();
        Bundle args = new Bundle();
        args.putString(Constant.TITLE, title);
        args.putString(Constant.TYPE, type);
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
        type = getArguments().getString(Constant.TYPE);
        mList = new ArrayList<>();
        rvAndroid.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AndroidAdapter(mList, getActivity());
        rvAndroid.setAdapter(adapter);
        presenter.getData(type);

        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getData(type);
            }
        });

        rvAndroid.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int last = ((LinearLayoutManager) rvAndroid.getLayoutManager()).findLastVisibleItemPosition();
                int total = rvAndroid.getLayoutManager().getItemCount();
                if (last >= total - 2 && dy > 0) {
                    presenter.getMoreData(type);
                }
            }
        });

        adapter.setOnItemClickListener(new AndroidAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent i = new Intent();
                i.setClass(getActivity(), ArticleDetailActivity.class);
                i.putExtra(Constant.DETAIL_URL, mList.get(position).getUrl());
                startActivity(i);
            }
        });


    }

    @Override
    public void showData(List<GankItemBean> list) {
        if (srlRefresh.isRefreshing()) {
            srlRefresh.setRefreshing(false);
        }
        mList.clear();
        mList.addAll(list);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showMoreData(List<GankItemBean> list) {
        mList.addAll(list);
        adapter.notifyDataSetChanged();
    }

}
