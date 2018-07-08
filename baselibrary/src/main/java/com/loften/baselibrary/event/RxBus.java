package com.loften.baselibrary.event;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * 事件总线
 */

public class RxBus {

//    //有背压处理的RxBus
//    private final FlowableProcessor<Object> mBus;

    //非背压处理
    private final Subject<Object> mBus;

    private static volatile RxBus defaultRxBus;


    private RxBus(){
        //非背压处理
        mBus = PublishSubject.create().toSerialized();

//        // 有背压处理的RxBus
//        mBus = PublishProcessor.create().toSerialized();
    }

    public static RxBus getInstance(){
        if(null == defaultRxBus){
            synchronized (RxBus.class){
                if(null == defaultRxBus){
                    defaultRxBus = new RxBus();
                }
            }
        }
        return defaultRxBus;
    }

    public void post(Object obj){
        mBus.onNext(obj);
    }

    public boolean hasObservable(){
        return mBus.hasObservers();
    }

    public Observable<Object> toObservable(){
        return mBus;
    }

    /*
    * 转换为特定类型的Obserbale
    */
    public <T> Observable<T> toObservable(Class<T> type) {
        return mBus.ofType(type);
    }

}
