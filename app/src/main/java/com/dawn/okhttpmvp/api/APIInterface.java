package com.dawn.okhttpmvp.api;

import com.dawn.httplib.http.response.BaseResult;
import com.dawn.okhttpmvp.test.response.GoodsListBean;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public interface APIInterface {


    @FormUrlEncoded
    @POST
    Observable<BaseResult<GoodsListBean>> doPost(@Url String Url, @FieldMap HashMap<String, String> map);
    @FormUrlEncoded
    @POST
    Observable<BaseResult<List>> doPost2(@Url String Url, @FieldMap HashMap<String, String> map);
}
