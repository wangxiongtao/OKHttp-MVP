package com.dawn.httplib.http.retrofit.function;

import android.util.Log;

import com.dawn.httplib.http.request.OkRequest;

import io.reactivex.functions.Function;
import okhttp3.ResponseBody;
import retrofit2.Response;


/**
 * Created by Administrator on 2018/2/6 0006.
 */

public class ResponseFun implements Function<Response<ResponseBody>,Object>{
    private OkRequest request;

    public ResponseFun(OkRequest request) {
        this.request = request;
    }

    @Override
    public Object apply(Response<ResponseBody> o) throws Exception {
        Log.e("aaa","===apply==url==>"+o.raw().request().url());
        Log.e("aaa","===apply==code==>"+o.raw().code());
        Log.e("aaa","===apply==code==>"+o.raw().request().tag());


//        BaseResult baseResult=new Gson().fromJson(o.body().string(),request.getGenericSuperclass());
//        OkResponse response=new OkResponse(request,o,o.body().string());

        return "";
    }
}
