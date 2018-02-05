package com.dawn.okhttpmvp.mvp;


import com.dawn.httplib.http.HttpCallBack;
import com.dawn.httplib.http.request.IRequest;

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

    public void post(IRequest request, HttpCallBack callBack){
        request.doPostRequest(callBack);
    }
    public void downLoad(IRequest request, HttpCallBack callBack){
        request.doDownloadRequest(callBack);
    }




}
