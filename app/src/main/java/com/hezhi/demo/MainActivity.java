package com.hezhi.demo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.hezhi.codepie.R;
import com.hezhi.demo.audio.ui.AudioActivity;
import com.hezhi.demo.rxjava.RxjavaActivity;
import com.hezhi.kiss.base.BaseActivity;
import com.hezhi.kiss.utils.PermissionUtil;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public void toSoftSlideActivity(View v) {
        /*Intent i = new Intent();
        i.setClass(MainActivity.this, SoftSlideActivity.class);
        startActivity(i);*/
        if(!PermissionUtil.hasPermission(this, Manifest.permission.CAMERA)) {
            PermissionUtil.requestPermisson(this,PermissionUtil.Constant.CAMERA_CODE,Manifest.permission.CAMERA);
        } else {
            doOpenCamera();
        }

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

    protected void toRxjava() {
        Intent i = new Intent();
        i.setClass(MainActivity.this, RxjavaActivity.class);
        startActivity(i);
    }
}
