package com.dawn.okhttpmvp.http.strategy;

import com.dawn.okhttpmvp.http.HttpCallBack;
import com.dawn.okhttpmvp.http.request.HttpRequest;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/1/19 0019.
 * 上传 请求 参考POST请求实现 {@link HttpPost}
 */

public class HttpUpload implements IHttpStrategy {
    @Override
    public void doRequest(OkHttpClient client, HttpRequest httpRequest, HttpCallBack callBack) {

    }
}
