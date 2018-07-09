package com.loften.mymvpmodel.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loften.baselibrary.ui.BaseFragment;
import com.loften.mymvpmodel.R;

/**
 *
 */
public class MeiziFragment extends BaseFragment {


    public MeiziFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_meizi, container, false);
    }

}
