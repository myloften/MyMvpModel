package com.loften.baselibrary.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter <T extends IBaseView> implements IPresenter<T>{

    /**
     * 绑定的view
     */
    protected T mView;
    /**
     * 将所有正在处理的Subscription都添加到CompositeSubscription中。统一退出的时候注销观察
     */
    private CompositeDisposable mCompositeDisposable;

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    @Override
    public void attachView(T mvpView) {
        this.mView = mvpView;
    }

    /**
     * 做初始化的操作,需要在V的视图初始化完成之后才能调用
     * presenter进行初始化.
     */
    public abstract void onCreate();

    /**
     * 断开view，一般在onDestroy中调用
     */
    @Override
    public void detachView() {
        this.mView = null;
    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     * 结束异步操作
     */
    @Override
    public void onDestroy() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void addDisposable(Disposable subscription) {
        //CompositeDisposable 如果解绑了的话添加 subscription 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }
}
