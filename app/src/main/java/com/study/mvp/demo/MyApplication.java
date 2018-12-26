package com.study.mvp.demo;

import android.app.Application;

import com.study.mvp.demo.base.RetrofitUtils;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/25 10:35
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitUtils.getInstances().initOKHttp(getApplicationContext());
    }
}
