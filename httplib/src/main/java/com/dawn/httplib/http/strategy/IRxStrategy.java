package com.dawn.httplib.http.strategy;

import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.OkResponse;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/1/31 0031.
 */

public interface IRxStrategy {
    Observable<OkResponse> getObservable(OkHttpClient client, OkRequest request);
}
