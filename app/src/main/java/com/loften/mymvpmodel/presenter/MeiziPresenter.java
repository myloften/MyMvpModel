package com.loften.mymvpmodel.presenter;

import com.loften.baselibrary.data.protocol.ExceptionHandle;
import com.loften.baselibrary.mvp.BasePresenter;
import com.loften.baselibrary.rx.BaseObserver;
import com.loften.mymvpmodel.contract.MeiziContract;
import com.loften.mymvpmodel.data.bean.Meizi;
import com.loften.mymvpmodel.model.MeiziModel;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class MeiziPresenter extends BasePresenter<MeiziContract.View> implements MeiziContract.Presenter {

    MeiziModel meiziModel;

    @Override
    public void onCreate() {
        meiziModel = new MeiziModel();
    }

    @Override
    public void getMeizi() {
        mView.showLoading();
        meiziModel.getMeizi()
        .subscribe(new BaseObserver<List<Meizi>>() {

            @Override
            public void call(List<Meizi> meizis) {
                mView.hideLoading();
                mView.showData(meizis);
            }

            @Override
            public void addDispos(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void error(ExceptionHandle.ResponeThrowable e) {
                mView.showToast(e.message);
                mView.hideLoading();
            }

        });

    }
}
