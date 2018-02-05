package com.dawn.httplib.http.strategy;


import com.dawn.httplib.http.HttpCallBack;
import com.dawn.httplib.http.handler.DownLoadHandler;
import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.OkResponse;
import com.dawn.httplib.http.strategy.rx.OkObserver;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2018/1/19 0019.
 * 下载 请求 参考POST请求实现 {@link HttpPost}
 */

public class HttpDownload implements IHttpStrategy, IRxStrategy {
    @Override
    public Observable<OkResponse> getObservable(final OkHttpClient client, final OkRequest request) {
        return Observable.create(new ObservableOnSubscribe<OkResponse>() {
            @Override
            public void subscribe(ObservableEmitter<OkResponse> emitter) {
                Request myRequest = new Request.Builder().url(request.getUrl()).tag(request.getTag()).build();
                Call call = client.newCall(myRequest);
                DownLoadHandler.downLoad(call,request,emitter);
            }
        });
    }

    @Override
    public void doRequest(OkHttpClient client, final OkRequest okRequest, final HttpCallBack callBack) {
        getObservable(client, okRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new OkObserver(okRequest,callBack){
                    @Override
                    public void onNext(OkResponse okResponse) {
                        callBack.onProgress((Integer)okResponse.getResponse().request().tag(),okResponse.getTotalSize(),okResponse.getCurrentSize(),okResponse.getPercent());
                    }
                });


    }


}
