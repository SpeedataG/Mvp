package com.spd.architecture;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.spd.lib.mvp.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected int getActLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
    }
}
