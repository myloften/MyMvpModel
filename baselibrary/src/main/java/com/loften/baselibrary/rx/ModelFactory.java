package com.loften.baselibrary.rx;

import com.loften.baselibrary.data.protocol.BaseResp;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 这里主要是请求完成后对返回的数据进行统一处理
 */

public class ModelFactory {

    private final static ObservableTransformer transformer = new SimpleTransformer();

    /**
     * 将Observable<BaseResponse<T>>转化Observable<T>,并处理BaseResponse
     * @return 返回过滤后的Observable.
     */
    @SuppressWarnings("unchecked")
    public static <T> Observable<T> compose(Observable<BaseResp<T>> observable){
        return observable.compose(transformer);
    }

    private static class SimpleTransformer<T> implements ObservableTransformer<BaseResp<T>, T> {
        @Override
        public ObservableSource<T> apply(Observable<BaseResp<T>> upstream) {
            return upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .unsubscribeOn(Schedulers.io())
                    .timeout(5, TimeUnit.SECONDS)//重连间隔时间
                    .retry(5)//重连次数
                    .flatMap(new Function<BaseResp<T>, Observable<T>>() {
                        @Override
                        public Observable<T> apply(BaseResp<T> tBaseResp) throws Exception {
                            return flatResponse(tBaseResp);
                        }
                    });
        }

        /**
         * 处理请求结果,BaseResponse
         * @param response 请求结果
         * @return 过滤处理, 返回只有data数据的Observable
         */
        private Observable<T> flatResponse(final BaseResp<T> response){
            return Observable.create(new ObservableOnSubscribe<T>() {
                @Override
                public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                    if(!response.isError()){//请求成功
                        if(!emitter.isDisposed()){
                           emitter.onNext(response.getResults());
                        }
                    }else{//请求失败
                        String resultCode = response.getStatus();
                        if (!emitter.isDisposed()){
                            //这里抛出自定义的一个异常.可以处理服务器返回的错误.
                            emitter.onError(new Throwable(resultCode));
                        }
                        return;
                    }
                    if(!emitter.isDisposed()){//请求完成
                        emitter.onComplete();
                    }
                }
            });
        }
    }
}
