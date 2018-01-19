package com.dawn.okhttpmvp.http.strategy;

import com.dawn.okhttpmvp.http.HttpCallBack;
import com.dawn.okhttpmvp.http.request.HttpRequest;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/11/23.
 */

public interface IHttpStrategy {
    void doRequest(OkHttpClient client, HttpRequest httpRequest, HttpCallBack callBack);
}
