package com.dawn.httplib.http;


import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.strategy.IHttpStrategy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Administrator on 2017/11/23.
 */

public class HttpMananger {
    private OkHttpClient okHttpClient;
    private static HttpMananger httpMananger;
    public static HttpMananger getInstance(){
        if(httpMananger==null){
            httpMananger=new HttpMananger();
        }
        return httpMananger;
    }
    private HttpMananger(){
        okHttpClient=getOkHttpClient();

    }
    public OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(30, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(30, TimeUnit.SECONDS)//设置连接超时时间
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return addHeader(chain);
                    }
                })
                .build();
    }

    public Retrofit getRetrofit(String baseUrl,OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

    }








    private Response addHeader(Interceptor.Chain chain) throws IOException {

        Request original = chain.request();


        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("storeId", "20001000001")
                .header("vendorId","20001" );
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }





    public void doRequest(IHttpStrategy http, OkRequest request, HttpCallBack callBack){
        http.doRequest(okHttpClient,request,callBack);
    }

    public void fun(){
        Observable observable=Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {

            }
        }).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<Object>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

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
