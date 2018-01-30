package com.dawn.httplib.http.log;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2018/1/30 0030.
 */

public class MyLog implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(String message) {
        Log.e("okhttp", "==>"+message);
    }
}
