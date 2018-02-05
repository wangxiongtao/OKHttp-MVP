package com.dawn.httplib.http.strategy.rx;

import com.dawn.httplib.http.HttpCallBack;
import com.dawn.httplib.http.exception.HttpException;
import com.dawn.httplib.http.handler.ResponseHandler;
import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.OkResponse;
import com.dawn.httplib.http.strategy.IHttpStrategy;
import com.dawn.httplib.http.strategy.IRxStrategy;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import static com.dawn.httplib.http.exception.HttpException.RESULT_NO_ERROR_CODE;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public class HttpPostRx implements IRxStrategy, IHttpStrategy {


    @Override
    public Observable<OkResponse> getObservable(final OkHttpClient client, final OkRequest request) {
        return Observable.create(new ObservableOnSubscribe<OkResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<OkResponse> emitter) {
                FormBody.Builder builder = new FormBody.Builder();
                HashMap<String, String> map = request.getParamMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    builder.add(entry.getKey(), entry.getValue());
                }
                FormBody body = builder.build();
                Request myRequest = new Request.Builder().url(request.getUrl()).post(body).tag(request.getTag()).build();
                Call call = client.newCall(myRequest);
                HttpException exception = ResponseHandler.checkHttp(request, call);
                if (exception.getCode() == HttpException.SERVER_NO_ERROR_CODE) {//服务器响应无错误
                    emitter.onNext(exception.getOkResponse());
                } else {
                    emitter.onError(exception);
                }
            }
        });
    }

    @Override
    public void doRequest(final OkHttpClient client, final OkRequest request, final HttpCallBack callBack) {
        getObservable(client, request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new OkObserver(request,callBack){
                    @Override
                    public void onNext(OkResponse o) {
                        super.onNext(o);
                        HttpException exception = ResponseHandler.checkResult(o, request.getmGenericSuperclass());
                        if (exception.getCode() == RESULT_NO_ERROR_CODE) {
                            callBack.onHttpSuccess((Integer) o.getResponse().request().tag(), exception.getResult().data);
                        } else {
                            onError(exception);
                        }
                    }
                });

//
    }


}
