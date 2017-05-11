package com.hezhi.codepie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hezhi.codepie.widget.test;
import com.hezhi.kiss.base.BaseActivity;

public class MainActivity extends BaseActivity {


     TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tvAchievements);

    }

    @test
    public void toSoftSlideActivity(View v) {
        Intent i = new Intent();
        i.setClass(MainActivity.this, SoftSlideActivity.class);
        startActivity(i);
    }
}
