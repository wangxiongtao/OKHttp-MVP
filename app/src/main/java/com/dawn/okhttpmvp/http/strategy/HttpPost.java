package com.dawn.okhttpmvp.http.strategy;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.dawn.okhttpmvp.http.HttpCallBack;
import com.dawn.okhttpmvp.http.request.HttpRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/11/23.
 * POST 请求
 */

public class HttpPost implements IHttpStrategy {

    @Override
    public void doRequest(OkHttpClient okHttpClient, HttpRequest request, final HttpCallBack callBack) {
        Log.e("aaa", "===执行开始======>" + request + "TAG==" + request.getTag() + "----------" + request.getParamMap());
        callBack.onHttpStart(10);
        try {
            FormBody.Builder builder = new FormBody.Builder();
            HashMap<String, String> map = request.getParamMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            FormBody body = builder.build();
            Request myRequest = new Request.Builder().url(request.getUrl()).post(body).tag(request.getTag()).build();
            Call call = okHttpClient.newCall(myRequest);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.e("aaa","===onFailure=========>" + e.getMessage());

                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    final String str = response.body().string();
                    final int tag = (int) call.request().tag();
                    Log.e("aaa","===onResponse=========>" + str);
                    Log.e("aaa","===onResponse===TAG======>" + tag);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onHttpSuccess(tag, str);
                        }
                    });


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
