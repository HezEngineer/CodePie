package com.hezhi.demo.audio.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hezhi.codepie.R;
import com.hezhi.codepie.audio.adapter.ViewHolder.AudioViewHolder;
import com.hezhi.kiss.Model.media.AudioBean;

import java.util.ArrayList;

/**
 * Created by yf11 on 2017/5/12.
 */

public class AudiosAdapter extends RecyclerView.Adapter<AudioViewHolder> {

    private ArrayList<AudioBean> audioList;
    private LayoutInflater inflater;

    public AudiosAdapter(Context context, ArrayList<AudioBean> audioList) {
        this.audioList = audioList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return audioList.size();
    }

    @Override
    public AudioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AudioViewHolder(inflater.inflate(R.layout.view_audio_item, parent, false));
    }

    @Override
    public void onBindViewHolder(AudioViewHolder holder, int position) {
        AudioBean audioBean = audioList.get(position);
        holder.tvName.setText(audioBean.getName());
    }
}
