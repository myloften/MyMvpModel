package com.loften.mymvpmodel.model;

import com.loften.baselibrary.data.net.RetrofitFactory;
import com.loften.baselibrary.rx.ModelFactory;
import com.loften.mymvpmodel.contract.MeiziContract;
import com.loften.mymvpmodel.data.api.NetWorkApi;
import com.loften.mymvpmodel.data.bean.Meizi;

import java.util.List;

import io.reactivex.Observable;

public class MeiziModel implements MeiziContract.Model {
    @Override
    public Observable<List<Meizi>> getMeizi() {
        return ModelFactory.compose(RetrofitFactory.getInstance().create(NetWorkApi.class).getMeizi());
    }

}
