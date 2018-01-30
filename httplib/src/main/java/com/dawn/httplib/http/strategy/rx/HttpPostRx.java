package com.dawn.httplib.http.strategy.rx;

import android.util.Log;

import com.dawn.httplib.http.HttpCallBack;
import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.OkResponse;
import com.dawn.httplib.http.strategy.IHttpStrategy;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public class HttpPostRx<T> implements IHttpStrategy {
    @Override
    public void doRequest(final OkHttpClient client, final OkRequest request, final HttpCallBack callBack) {
        ObservableUtil.getObservable(client, request)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OkResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if(callBack==null){
                            return;
                        }
                        callBack.onHttpStart(request.getTag());



                    }

                    @Override
                    public void onNext(OkResponse o) {
                        Log.e("aaa", "" + o);
                        if(callBack==null){
                            return;
                        }
                        callBack.onHttpSuccess((Integer) o.getResponse().request().tag(),o.getResultJson());



                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callBack==null){
                            return;
                        }
                        callBack.onHttpFail(request.getTag(),e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


}
