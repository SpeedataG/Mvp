package com.spd.lib.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;


/**
 * @author :Reginer in  2017/9/18 13:13.
 *         联系方式:QQ:282921012
 *         功能描述:mvp基类activity
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    /**
     * 创建presenter
     *
     * @return presenter
     */
    protected abstract P createPresenter();
}