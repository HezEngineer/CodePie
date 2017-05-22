package com.hezhi.demo.audio.ui;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hezhi.codepie.R;
import com.hezhi.demo.audio.adapter.AudiosAdapter;
import com.hezhi.kiss.base.BaseSimpleActivity;
import com.hezhi.kiss.utils.MediaUtil;

import butterknife.BindView;

/**
 * Created by yf11 on 2017/5/12.
 */

public class AudioActivity extends BaseSimpleActivity {


    @BindView(R.id.rv_audios)
    RecyclerView rvAudios;

    private AudiosAdapter audiosAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvAudios = (RecyclerView)  findViewById(R.id.rv_audios);
        audiosAdapter = new AudiosAdapter(this, MediaUtil.getAllAudios(this));
        layoutManager =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvAudios.setLayoutManager(layoutManager);
        rvAudios.setAdapter(audiosAdapter);

        final SpringAnimation anim = new SpringAnimation(rvAudios, DynamicAnimation.TRANSLATION_Y, 0)
                .setStartVelocity(5000);
        anim.start();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_audio;
    }
}
