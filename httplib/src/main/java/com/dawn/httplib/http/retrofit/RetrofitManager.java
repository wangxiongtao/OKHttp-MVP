package com.dawn.httplib.http.retrofit;

import com.dawn.httplib.http.API;
import com.dawn.httplib.http.HttpCallBack;
import com.dawn.httplib.http.HttpMananger;
import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.retrofit.function.ResponseFun;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

public class RetrofitManager {
    private Retrofit retrofit;
    private HttpCallBack callBack;


    private static class SingletonHolder {
        private static RetrofitManager instance = new RetrofitManager();
    }

    public static RetrofitManager getInstance() {
        return SingletonHolder.instance;
    }

    private RetrofitManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(HttpMananger.getInstance().getOkHttpClient())
                .build();
    }

    public Observable<Object> setRequest(final OkRequest... request) {
        Observable<Object> observable=null;
        for (int i=0;i<request.length;i++){
            Observable<Object> tempOb;
            final OkRequest okRequest=request[i];
            HashMap<String, String> map = okRequest.getParamMap();

            if(i==0){
                observable = retrofit.create(APIInterface.class)
                        .doPost(okRequest.getUrl(), map)
                        .map(new ResponseFun(okRequest));
                continue;
            }
            tempOb = retrofit.create(APIInterface.class)
                    .doPost(okRequest.getUrl(), map)
                    .map(new ResponseFun(okRequest));
            observable=observable.mergeWith(tempOb);
        }

        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


    public void sendRequest(Class c){
//        Observable observable=retrofit.create(c)


    }



    public void setCallBack(HttpCallBack callBack) {
        this.callBack = callBack;
    }
}
