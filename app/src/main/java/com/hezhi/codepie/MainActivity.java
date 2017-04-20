package com.hezhi.codepie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hezhi.kiss.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void toSoftSlideActivity(View v) {
        Intent i = new Intent();
        i.setClass(MainActivity.this, SoftSlideActivity.class);
        startActivity(i);
    }
}
