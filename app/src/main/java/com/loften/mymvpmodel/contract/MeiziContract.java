package com.loften.mymvpmodel.contract;

import com.loften.baselibrary.data.protocol.BaseResp;
import com.loften.baselibrary.mvp.IBaseView;
import com.loften.mymvpmodel.data.bean.Meizi;

import java.util.List;

import io.reactivex.Observable;

public interface MeiziContract {

    interface Model {
        void getMeizi(Presenter presenter);
    }

    interface View extends IBaseView{
        void onSuccess(BaseResp<List<Meizi>> meizis);
    }

    interface Presenter{
        BaseResp<List<Meizi>> getMeizi();
    }
}
