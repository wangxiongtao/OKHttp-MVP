package com.dawn.httplib.http.request;


import com.dawn.httplib.http.HttpCallBack;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public interface IRequest<T> {


     int getTag();

     String getUrl();


    HashMap<String, String> getParamMap();

    void doGetRequest(HttpCallBack callBack);

    void doPostRequest(HttpCallBack callBack);

    void doDownloadRequest(HttpCallBack callBack);

    void doUpLoadRequest(HttpCallBack callBack);


}
