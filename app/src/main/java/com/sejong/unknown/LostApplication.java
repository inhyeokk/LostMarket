package com.sejong.unknown;

import android.app.Application;

import com.sejong.unknown.service.retrofit.RetrofitHelper;

public class LostApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitHelper.init();
    }
}
