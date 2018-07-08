package com.loften.baselibrary.ui.activity;


import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.loften.baselibrary.mvp.BasePresenter;
import com.loften.baselibrary.mvp.IBaseView;

public class BaseMvpActivity<T extends BasePresenter<?>> extends BaseActivity implements IBaseView{

    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLifecycleObserver(getLifecycle());
    }

    private void initLifecycleObserver(Lifecycle lifecycle) {
        mPresenter.setLifecycleOwner(this);
        lifecycle.addObserver(mPresenter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError() {

    }
}
