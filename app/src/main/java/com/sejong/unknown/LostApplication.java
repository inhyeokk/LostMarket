package com.sejong.unknown;

import android.app.Application;

import com.sejong.unknown.service.retrofit.RetrofitHelper;
import com.sejong.unknown.util.ImageUtil;
import com.sejong.unknown.view.main.adapter.LostBindingAdapter;

public class LostApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitHelper.init();
        ImageUtil.init(this);
        LostBindingAdapter.init(this);
    }
}
