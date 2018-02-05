package com.dawn.httplib.http;


import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.strategy.IHttpStrategy;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.Nullable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Converter;
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

    public Retrofit getRetrofit(String baseUrl,OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(new Converter.Factory() {
                    @Nullable
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return super.responseBodyConverter(type, annotations, retrofit);
                    }

                    @Nullable
                    @Override
                    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
                        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
                    }

                    @Nullable
                    @Override
                    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return super.stringConverter(type, annotations, retrofit);
                    }
                })
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



}
