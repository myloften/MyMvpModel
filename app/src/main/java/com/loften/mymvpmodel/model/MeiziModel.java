package com.loften.mymvpmodel.model;

import android.widget.Toast;

import com.loften.baselibrary.data.net.RetrofitFactory;
import com.loften.baselibrary.data.protocol.BaseResp;
import com.loften.mymvpmodel.contract.MeiziContract;
import com.loften.mymvpmodel.data.api.NetWorkApi;
import com.loften.mymvpmodel.data.bean.Meizi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MeiziModel implements MeiziContract.Model {

    @Override
    public void getMeizi(final MeiziContract.Presenter presenter) {
        RetrofitFactory.getInstance().create(NetWorkApi.class).getMeizi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseResp<List<Meizi>>>() {
                    @Override
                    public void accept(BaseResp<List<Meizi>> baseResp) throws Exception {
                        presenter.getMeizi();
                    }
                });
    }
}
