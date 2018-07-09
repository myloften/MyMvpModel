package com.loften.baselibrary.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.loften.baselibrary.mvp.BasePresenter;
import com.loften.baselibrary.ui.BaseActivity;

/**
 * 基类MvpActivity
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity {

    protected T mPresenter;

    /**
     * 创建prensenter
     * @return <T extends BasePresenter> 必须是BasePresenter的子类
     */
    protected abstract T initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建Presenter
        mPresenter = initPresenter();
        mPresenter.attachView(this);
        mPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        mPresenter.detachView();
        super.onDestroy();
    }
}
