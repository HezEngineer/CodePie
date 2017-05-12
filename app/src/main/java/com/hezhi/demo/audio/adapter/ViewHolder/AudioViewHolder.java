package com.hezhi.demo.audio.adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.TextView;

import com.hezhi.codepie.R;

/**
 * Created by yf11 on 2017/5/12.
 */

public class AudioViewHolder  extends RecyclerView.ViewHolder{
    public TextView tvName;
    public SwitchCompat scPlay;

    public AudioViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        scPlay = (SwitchCompat) itemView.findViewById(R.id.sc_play);
    }
}
