package com.hezhi.gank.ui.gank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hezhi.gank.R;
import com.hezhi.gank.model.bean.GankItemBean;

import java.util.List;

/**
 * Created by yf11 on 2017/6/21.
 */

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidVH> {

    private List<GankItemBean> list;
    private Context context;
    private LayoutInflater inflater;

    public AndroidAdapter(List<GankItemBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public AndroidVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AndroidVH(inflater.inflate(R.layout.view_android_item,parent,false));
    }

    @Override
    public void onBindViewHolder(AndroidVH holder, int position) {
        holder.tvTitle.setText(list.get(position).getDesc());
        holder.tvAuthor.setText(list.get(position).getWho());
        holder.tvTime.setText(list.get(position).getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class AndroidVH extends RecyclerView.ViewHolder {

        private ImageView ivBg;
        private TextView tvTitle;
        private TextView tvAuthor;
        private TextView tvTime;

        public AndroidVH(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        }
    }
}
