package com.loften.baselibrary.ui;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.loften.baselibrary.mvp.IBaseView;
import com.loften.baselibrary.ui.BaseActivity;

/**
 * 基类Fragment
 */
public class BaseFragment extends Fragment implements IBaseView{

    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void showLoading() {
        ((BaseActivity)mContext).showLoading();
    }

    @Override
    public void hideLoading() {
        ((BaseActivity)mContext).hideLoading();
    }

    @Override
    public void showToast(String msg) {
        ((BaseActivity)mContext).showToast(msg);
    }

    @Override
    public void onError() {
        ((BaseActivity)mContext).onError();
    }

    public Context getContext() {
        return mContext;
    }
}
