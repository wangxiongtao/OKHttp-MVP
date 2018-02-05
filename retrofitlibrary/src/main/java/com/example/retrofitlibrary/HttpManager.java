package com.example.retrofitlibrary;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public class HttpManager {


    public Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();

    }

    public void init()  {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();
        APIInterface service = retrofit.create(APIInterface.class);
        Call<MyClass> model = service.repo("Guolei1130");
        Observable<MyClass> model2 = service.repo2("Guolei1130");
        model2.subscribe(new Observer<MyClass>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MyClass myClass) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });




        model.enqueue(new Callback<MyClass>() {
            @Override
            public void onResponse(Call<MyClass> call, Response<MyClass> response) {


            }

            @Override
            public void onFailure(Call<MyClass> call, Throwable t) {

            }
        });

    }
}
