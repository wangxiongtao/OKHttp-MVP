package com.example.retrofitlibrary;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public interface APIInterface {
    @GET("/users/{user}")
    Call<MyClass> repo(@Path("user") String user);
    Observable<MyClass> repo2(@Path("user") String user);


    @FormUrlEncoded
    Observable<MyClass> doPost(@Url String Url,@FieldMap Map<String, String> map);
}
