package com.hezhi.gank.ui.gank.fragment;


import android.os.Bundle;

import com.hezhi.gank.R;
import com.hezhi.gank.common.constant.Constant;
import com.hezhi.kiss.base.BaseSimpleFragment;


public class FrontFragment extends BaseSimpleFragment {

 public static FrontFragment newInstance(String title) {
  FrontFragment frontFragment = new FrontFragment();
  Bundle args = new Bundle();
  args.putString(Constant.TITLE,title);
  frontFragment.setArguments(args);
  return frontFragment;
 }

 @Override
 protected int getLayoutId() {
  return R.layout.fragment_froniter;
 }
}
