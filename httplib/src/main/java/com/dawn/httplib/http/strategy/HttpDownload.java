package com.dawn.httplib.http.strategy;


import com.dawn.httplib.http.HttpCallBack;
import com.dawn.httplib.http.request.OkRequest;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/1/19 0019.
 * 下载 请求 参考POST请求实现 {@link HttpPost}
 */

public class HttpDownload implements IHttpStrategy {
    @Override
    public void doRequest(OkHttpClient client, OkRequest okRequest, HttpCallBack callBack) {

    }
}
