package com.loften.baselibrary.base;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class BaseApp extends Application{

    private List<Activity> mActivities;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    //各项初始化
    private void init() {

    }

    public List<Activity> getActivities(){
        if(mActivities == null){
            mActivities = new ArrayList<>();
        }
        return mActivities;
    }

    public void finishAllActivities(){
        if(mActivities != null && mActivities.size() != 0){
            for (Activity activity : mActivities) {
                activity.finish();
            }
        }
    }
}
