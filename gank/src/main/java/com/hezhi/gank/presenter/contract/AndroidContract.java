package com.hezhi.gank.presenter.contract;

import com.hezhi.gank.model.bean.GankItemBean;
import com.hezhi.kiss.base.BasePresenter;
import com.hezhi.kiss.base.BaseView;

import java.util.List;

/**
 * Created by yf11 on 2017/6/15.
 */

public interface AndroidContract {

    interface View extends BaseView {
        void showData(List<GankItemBean> list);
        void showMoreData(List<GankItemBean> list);
    }

    interface Presenter extends BasePresenter<View> {

        void getData(String type);
        void getMoreData(String type);

    }
}
