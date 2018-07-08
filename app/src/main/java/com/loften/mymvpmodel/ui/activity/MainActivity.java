package com.loften.mymvpmodel.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loften.baselibrary.data.net.RetrofitFactory;
import com.loften.baselibrary.data.protocol.BaseResp;
import com.loften.baselibrary.ui.activity.BaseMvpActivity;
import com.loften.mymvpmodel.R;
import com.loften.mymvpmodel.contract.MeiziContract;
import com.loften.mymvpmodel.data.api.NetWorkApi;
import com.loften.mymvpmodel.data.bean.Meizi;
import com.loften.mymvpmodel.presenter.MeiziPresenter;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseMvpActivity<MeiziPresenter> implements View.OnClickListener, MeiziContract.View {

    private Button btn;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mPresenter = new MeiziPresenter();
        mPresenter.mView = this;

    }


    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        img = (ImageView) findViewById(R.id.img);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:

                break;
        }
    }


    @Override
    public void showLoading() {
        Toast.makeText(this, "加载中。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(this, "加载完。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "哎呀，出错啦。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(BaseResp<List<Meizi>> meizis) {
        Glide.with(this).load(meizis.getResults().get(0).getUrl()).into(img);
    }
}
