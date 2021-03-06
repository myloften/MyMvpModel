package com.loften.baselibrary.rx;

import com.loften.baselibrary.data.protocol.ExceptionHandle;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {
        addDispos(d);
    }

    @Override
    public void onNext(T t) {
        if(t != null){
            call(t);
        }else {}
    }

    @Override
    public void onError(Throwable e) {
        error(ExceptionHandle.handleException(e));
    }

    @Override
    public void onComplete() {

    }

    public abstract void call(T t);

    public abstract void addDispos(Disposable d);

    public abstract void error(ExceptionHandle.ResponeThrowable e);
}
