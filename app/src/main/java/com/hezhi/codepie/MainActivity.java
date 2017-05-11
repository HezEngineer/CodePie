package com.hezhi.codepie;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import com.hezhi.kiss.base.BaseActivity;
import com.hezhi.kiss.utils.PermissionUtil;

public class MainActivity extends BaseActivity {


     TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tvAchievements);

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

    @Override
    protected void doOpenCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }
}
