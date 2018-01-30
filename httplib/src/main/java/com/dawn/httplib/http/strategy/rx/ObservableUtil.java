package com.dawn.httplib.http.strategy.rx;

import com.dawn.httplib.http.exception.CheckReponse;
import com.dawn.httplib.http.exception.HttpException;
import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.OkResponse;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.dawn.httplib.http.exception.HttpException.SERVER_ERROR_MSG;

/**
 * Created by Administrator on 2018/1/30 0030.
 */

public class ObservableUtil {
    public static Observable<OkResponse> getObservable(final OkHttpClient client, final OkRequest request) {
        return Observable.create(new ObservableOnSubscribe<OkResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<OkResponse> emitter) {
                try {
                    FormBody.Builder builder = new FormBody.Builder();
                    HashMap<String, String> map = request.getParamMap();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        builder.add(entry.getKey(), entry.getValue());
                    }
                    FormBody body = builder.build();
                    Request myRequest = new Request.Builder().url(request.getUrl()).post(body).tag(request.getTag()).build();
                    Call call = client.newCall(myRequest);
                    Response response=call.execute();
                    String json=response.body().string();
                    HttpException exception= CheckReponse.check(json);
                    if(exception==null){//没有异常
                        OkResponse r=new OkResponse(request,response,json);
                        emitter.onNext(r);
                    }else {
                        emitter.onError(exception);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    HttpException exception=new HttpException(SERVER_ERROR_MSG);
                    emitter.onError(exception);
                }
            }
        });

    }
}
