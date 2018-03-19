package com.dawn.httplib.http.retrofit;

import com.dawn.httplib.http.HttpCallBack;
import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.OkResponse;
import com.dawn.httplib.http.strategy.IHttpStrategy;
import com.dawn.httplib.http.strategy.IRxStrategy;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public class HttpPostRetro<T> implements IRxStrategy, IHttpStrategy {


    @Override
    public void doRequest(OkHttpClient client, final OkRequest okRequest, HttpCallBack callBack) {
        HashMap<String,String>map=okRequest.getParamMap();
//     Observable<ResponseBody> observable=HttpMananger.getInstance().getRetrofit("http://appapi.ohtest.quanshishequ.com/api/",client).create(APIInterface.class).doPost(okRequest.getUrl(),map);
//      observable.subscribeOn(Schedulers.io())
//              .observeOn(AndroidSchedulers.mainThread())
//              .subscribe(new Observer<ResponseBody>() {
//                  @Override
//                  public void onSubscribe(Disposable d) {
//
//                  }
//
//                  @Override
//                  public void onNext(ResponseBody okResponse) {
//                      try {
//                          Log.e("aaa","=======onNext=====>"+okResponse.string());
//                      } catch (IOException e) {
//                          e.printStackTrace();
//                      }
//
//                  }
//
//                  @Override
//                  public void onError(Throwable e) {
//
//                  }
//
//                  @Override
//                  public void onComplete() {
//
//                  }
//              });



    }

    @Override
    public Observable<OkResponse> getObservable(OkHttpClient client, OkRequest request) {
        return null;
    }
}
