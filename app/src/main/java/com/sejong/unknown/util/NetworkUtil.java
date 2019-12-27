package com.sejong.unknown.util;

import android.annotation.SuppressLint;
import android.os.StrictMode;

public class NetworkUtil {
    @SuppressLint("NewApi")
    public static void setNetworkPolicy() {
        if (android.os.Build.VERSION.SDK_INT > 23) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}


