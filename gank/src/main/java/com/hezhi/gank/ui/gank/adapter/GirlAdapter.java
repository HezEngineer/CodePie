package com.hezhi.gank.ui.gank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hezhi.gank.R;
import com.hezhi.gank.common.constant.Constant;
import com.hezhi.gank.model.bean.GankItemBean;

import java.util.List;

/**
 * Created by yf11 on 2017/6/29.
 */

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.GirlVH> {

    LayoutInflater inflater;
    List<GankItemBean> girlList;
    Context context;
    public GirlAdapter(Context context, List<GankItemBean> girlList) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.girlList = girlList;
    }

    @Override
    public GirlVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GirlVH(inflater.inflate(R.layout.item_girl,parent,false));
    }

    @Override
    public void onBindViewHolder(GirlVH holder, int position) {
        Glide.with(context).load(girlList.get(position).getUrl()+ Constant.ARGU_IMAGE_CROP).into(holder.iv_gril);
    }

    @Override
    public int getItemCount() {
        return girlList.size();
    }

    class GirlVH extends RecyclerView.ViewHolder{
        ImageView iv_gril;
        public GirlVH(View itemView) {
            super(itemView);
            iv_gril = (ImageView) itemView.findViewById(R.id.iv_girl);
        }
    }
}
