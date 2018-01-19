package com.dawn.okhttpmvp.http.request;

import com.dawn.okhttpmvp.http.HttpCallBack;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public interface IRequest {
    HashMap<String, String> getParamMap();

    void doGetRequest(HttpCallBack callBack);

    void doPostRequest(HttpCallBack callBack);

    void doDownloadRequest(HttpCallBack callBack);

    void doUpLoadRequest(HttpCallBack callBack);


}
