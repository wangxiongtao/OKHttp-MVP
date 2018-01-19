package com.dawn.okhttpmvp.http;

import com.dawn.okhttpmvp.http.request.HttpRequest;
import com.dawn.okhttpmvp.http.strategy.IHttpStrategy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
    OkHttpClient getOkHttpClient() {
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


    private Response addHeader(Interceptor.Chain chain) throws IOException {

        Request original = chain.request();


        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("storeId", "20001000001")
                .header("vendorId","20001" );
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }





    public void doRequest(IHttpStrategy http, HttpRequest request, HttpCallBack callBack){
        http.doRequest(okHttpClient,request,callBack);
    }



}
