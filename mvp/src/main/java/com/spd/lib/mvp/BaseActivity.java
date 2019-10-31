package com.spd.lib.mvp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import java.util.Objects;

/**
 * @author :Reginer in  2017/9/18 12:17.
 * 联系方式:QQ:282921012
 * 功能描述:Activity基类，所有Activity父类<p>
 * Activity的生命周期除了{@link #onRestart()}是两两对应的，其中有super，在每个生命周期中执行任务需要注意:</p>
 * 在onCreate、onStart、onResume、onRestart方法中执行，把要执行的方法放到super下一行写，其他的放到super上一行写
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected Toolbar mToolBar;
    protected TextView mToolbarTitle;
    private Dialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.mvp_base_layout);
        FrameLayout viewContent = findViewById(R.id.view_content);
        LayoutInflater.from(BaseActivity.this).inflate(getActLayoutId(), viewContent);
        initView(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initToolbar();
    }


    /**
     * 初始化ToolBar. <p>
     * 因为ToolBar的变化很小，所以这里就在这里初始化一下，如果有其他Activity有变化，可以使用{@link #mToolBar}的对应方法来设置<p>
     * 当然，也可以参照{@link #initView(Bundle)}方法来写.
     */
    protected void initToolbar() {
        mToolBar = findViewById(R.id.toolbar);
        mToolbarTitle = mToolBar.findViewById(R.id.toolbarTitle);
        mToolbarTitle.setText(MvpUtil.getActLabel(mContext, mContext.getClass().getName()));
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 获取activity布局.
     *
     * @return layout
     */
    @LayoutRes
    protected abstract int getActLayoutId();

    /**
     * 在这个方法中初始化控件.
     *
     * @param savedInstanceState 保存的数据,就是{@link #onSaveInstanceState(Bundle)}中的outState.
     */
    protected abstract void initView(@Nullable Bundle savedInstanceState);

    /**
     * 显示等待框 .
     */
    public void showProgress() {
        if (mDialog == null) {
            mDialog = new Dialog(this);
            Objects.requireNonNull(mDialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
            ProgressBar progressBar = new ProgressBar(this);
            progressBar.setIndeterminateDrawable(ContextCompat.getDrawable(this, R.drawable.mvp_progressbar));
            mDialog.setContentView(progressBar);
        }
        mDialog.show();
    }

    /**
     * 取消等待框 .
     */
    public void dismissProgress() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
}
