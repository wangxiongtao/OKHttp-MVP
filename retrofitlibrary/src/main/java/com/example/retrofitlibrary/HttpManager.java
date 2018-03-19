package com.example.retrofitlibrary;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public class HttpManager {
    static class Request{

    }


    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();

    }

    public static Observable<ResponseBody> init(Request request)  {
        APIInterface service = getRetrofit().create(APIInterface.class);
        Observable<ResponseBody> model2 = service.doPost("",new HashMap<String, String>());

        return  Observable.merge(model2,model2);


    }

    public static void main(String[] args) {
        init(new Request())
                .mergeWith( init(new Request()))
                .subscribe(new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody myClass) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
