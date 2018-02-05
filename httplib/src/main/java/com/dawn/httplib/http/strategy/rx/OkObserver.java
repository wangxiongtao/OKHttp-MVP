package com.dawn.httplib.http.strategy.rx;

import com.dawn.httplib.http.HttpCallBack;
import com.dawn.httplib.http.log.OkLogPrinter;
import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.OkResponse;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/2/5 0005.
 */

public class OkObserver implements Observer<OkResponse> {
    private OkRequest okRequest;
    private HttpCallBack callBack;

    public OkObserver(OkRequest okRequest, HttpCallBack callBack) {
        this.okRequest = okRequest;
        this.callBack = callBack;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if(callBack!=null){
            callBack.onHttpStart(okRequest.getTag());
        }

    }

    @Override
    public void onNext(OkResponse okResponse) {
        OkLogPrinter.logSucess(okResponse);

    }

    @Override
    public void onError(Throwable e) {
        OkLogPrinter.logFail(e);
        if(callBack!=null){
            callBack.onHttpFail(okRequest.getTag(),e.getMessage());
        }

    }

    @Override
    public void onComplete() {

    }
}
