package com.dawn.httplib.http;

/**
 * Created by Administrator on 2017/10/21.
 */

public interface HttpCallBack {
    void onHttpStart(int tag);

    void onHttpSuccess(int tag, String response);

    void onHttpFail(int tag,String errorMsg);

    void onProgress(long total, long current);
}
