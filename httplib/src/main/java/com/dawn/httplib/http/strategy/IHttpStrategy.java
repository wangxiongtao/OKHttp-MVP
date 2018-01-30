package com.dawn.httplib.http.strategy;


import com.dawn.httplib.http.HttpCallBack;
import com.dawn.httplib.http.request.OkRequest;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/11/23.
 */

public interface IHttpStrategy {
    String TAG="OKHTTP";
    void doRequest(OkHttpClient client, OkRequest okRequest, HttpCallBack callBack);
}
