package com.dawn.okhttpmvp.http;

/**
 * Created by Administrator on 2017/10/21.
 */

public interface HttpCallBack {
    void onHttpStart(int tag);

    void onHttpSuccess(int tag,String response);

    void onHttpFail(int tag);

    void onProgress(long total, long current);
}
