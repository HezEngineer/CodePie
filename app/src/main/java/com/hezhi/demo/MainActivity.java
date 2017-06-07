package com.hezhi.demo;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.hezhi.codepie.R;
import com.hezhi.demo.Anim.SoftSlideActivity;
import com.hezhi.demo.audio.ui.AudioActivity;
import com.hezhi.demo.rxjava.RxjavaActivity;
import com.hezhi.kiss.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn3:
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public void toSoftSlideActivity(View v) {
        Intent i = new Intent();
        i.setClass(MainActivity.this, SoftSlideActivity.class);
        startActivity(i);
        /*if(!PermissionUtil.hasPermission(this, Manifest.permission.CAMERA)) {
            PermissionUtil.requestPermisson(this,PermissionUtil.Constant.CAMERA_CODE,Manifest.permission.CAMERA);
        } else {
            doOpenCamera();
        }*/

    }

    public void toAudio(View v) {
        Intent i = new Intent();
        i.setClass(MainActivity.this, AudioActivity.class);
        startActivity(i);

    }

    @Override
    protected void doOpenCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    public void toRxjava(View v) {
        Intent i = new Intent();
        i.setClass(MainActivity.this, RxjavaActivity.class);
        startActivity(i);
    }

    public void toViewPager(View v) {
        Intent i = new Intent();
        i.setClass(MainActivity.this, ViewPagerActivity.class);
        startActivity(i);
    }
}
