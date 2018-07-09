package com.loften.mymvpmodel.contract;

import com.loften.baselibrary.mvp.IBaseView;
import com.loften.mymvpmodel.data.bean.Meizi;

import java.util.List;

import io.reactivex.Observable;

public interface MeiziContract {

    interface Model {
        Observable<List<Meizi>> getMeizi();
    }

    interface View extends IBaseView{
        void showData(List<Meizi> meizis);
    }

    interface Presenter{
        void getMeizi();
    }
}
