package com.loften.baselibrary.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.loften.baselibrary.mvp.BasePresenter;
import com.loften.baselibrary.ui.BaseFragment;

/**
 * 基类MvpFragment
 */
public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment {

    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建presenter
        mPresenter = initPresenter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.attachView(this);
        mPresenter.onCreate();
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDestroy();
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        mPresenter.detachView();
        super.onDetach();
    }

    /**
     * 创建prensenter
     *
     * @return <T extends BasePresenter> 必须是BasePresenter的子类
     */
    public abstract T initPresenter();

}
