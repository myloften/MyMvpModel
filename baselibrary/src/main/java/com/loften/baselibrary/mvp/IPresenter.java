package com.loften.baselibrary.mvp;

import io.reactivex.disposables.Disposable;

public interface IPresenter<T>{

    /**
     * presenter绑定view生命周期
     */
    void onCreate();

    void attachView(T mvpView);

    void detachView();

    void onDestroy();

    /**
     * rxjava网络请求添加统一管理
     */
    void addDisposable(Disposable subscription);

}
