package com.loften.mymvpmodel.base;

import com.loften.baselibrary.base.BaseApp;

public class App extends BaseApp{

    private static App instance;

    public static App getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
