package com.loften.mymvpmodel.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.loften.baselibrary.ui.BaseMvpActivity;
import com.loften.mymvpmodel.R;
import com.loften.mymvpmodel.contract.MeiziContract;
import com.loften.mymvpmodel.data.bean.Meizi;
import com.loften.mymvpmodel.presenter.MeiziPresenter;

import java.util.List;
import java.util.Random;


public class MainActivity extends BaseMvpActivity<MeiziPresenter> implements View.OnClickListener, MeiziContract.View {

    private Button btn;
    private ImageView img;

    @Override
    protected MeiziPresenter initPresenter() {
        return  new MeiziPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

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
                mPresenter.getMeizi();
                break;
        }
    }


    @Override
    public void showData(List<Meizi> meizis) {
        Random random = new Random();
        int i = random.nextInt(meizis.size());
        Glide.with(this).load(meizis.get(i).getUrl()).into(img);
    }
}
