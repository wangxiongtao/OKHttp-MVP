package com.dawn.okhttpmvp.test;

import com.dawn.httplib.http.response.BaseResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2018/1/31 0031.
 */

public class TTest<E> {
    public  E getData() {
        String str="{\"code\":\"0000\",\"msg\":\"获取门店分类商品成功\",\"data\":[],\"action\":null}";
        Gson gson = new Gson();
        Type jsonType = new TypeToken<BaseResult<E>>() {
        }.getType();
        BaseResult<E> r=gson.fromJson(str, jsonType);
        return r.data;
    }

    public static void main(String[] args) {
        TTest<Integer> test=new TTest<>();
        System.out.print("===>"+test.getData().getClass());
    }
}
