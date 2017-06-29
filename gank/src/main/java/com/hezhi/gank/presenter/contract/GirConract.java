package com.hezhi.gank.presenter.contract;

import com.hezhi.gank.model.bean.GankItemBean;
import com.hezhi.kiss.base.BasePresenter;
import com.hezhi.kiss.base.BaseView;

import java.util.List;

/**
 * Created by yf11 on 2017/6/29.
 */

public interface GirConract {
    interface View extends BaseView {
        void showGirls(List<GankItemBean> list);
    }
    interface Presenter extends BasePresenter<View> {
        void getGirls(String type);
    }
}
