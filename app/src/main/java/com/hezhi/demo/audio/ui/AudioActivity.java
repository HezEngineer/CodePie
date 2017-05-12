package com.hezhi.demo.audio.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.hezhi.codepie.R;
import com.hezhi.demo.audio.adapter.AudiosAdapter;
import com.hezhi.kiss.base.BaseActivity;
import com.hezhi.kiss.utils.MediaUtil;

import butterknife.BindView;

/**
 * Created by yf11 on 2017/5/12.
 */

public class AudioActivity extends BaseActivity {
    @BindView(R.id.rv_audios)
    RecyclerView rvAudios;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        rvAudios.setAdapter(new AudiosAdapter(this, MediaUtil.getAllAudios(this)));

    }
}
