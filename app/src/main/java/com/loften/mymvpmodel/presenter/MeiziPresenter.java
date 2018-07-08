package com.loften.mymvpmodel.presenter;

import com.loften.baselibrary.data.protocol.BaseResp;
import com.loften.baselibrary.mvp.BasePresenter;
import com.loften.mymvpmodel.contract.MeiziContract;
import com.loften.mymvpmodel.data.bean.Meizi;

import java.util.List;

public class MeiziPresenter extends BasePresenter<MeiziContract.View> implements MeiziContract.Presenter {

    @Override
    public BaseResp<List<Meizi>> getMeizi() {

        return null;
    }
}
