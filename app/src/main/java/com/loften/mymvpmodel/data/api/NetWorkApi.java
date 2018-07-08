package com.loften.mymvpmodel.data.api;

import com.loften.baselibrary.data.protocol.BaseResp;
import com.loften.mymvpmodel.data.bean.Meizi;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetWorkApi {
    @GET("data/福利/10/1")
    Observable<BaseResp<List<Meizi>>> getMeizi();

}
