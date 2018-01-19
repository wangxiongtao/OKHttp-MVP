package com.dawn.okhttpmvp.mvp;


import com.dawn.okhttpmvp.http.HttpCallBack;
import com.dawn.okhttpmvp.http.request.HttpRequest;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class IModel {

    private static IModel iModel;
    public static IModel getInstance(){
        if(iModel==null){
            iModel=new IModel();
        }
        return iModel;
    }

    public void post(HttpRequest request, HttpCallBack callBack){
        request.doPostRequest(callBack);
    }




}
