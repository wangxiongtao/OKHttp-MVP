package com.dawn.okhttpmvp.base;


import com.dawn.httplib.http.HttpCallBack;
import com.dawn.okhttpmvp.mvp.IPresenter;
import com.dawn.okhttpmvp.mvp.IView;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public abstract class BasePresenter implements IPresenter,HttpCallBack {
    private WeakReference<IView> viewRef;

    public BasePresenter(IView view){
        viewRef=new WeakReference<>(view);
    }

    @Override
    public IView getView() {
        if(viewRef==null){
            return null;
        }
        return viewRef.get();
    }

    @Override
    public void onHttpStart(int tag) {
        if(getView()!=null){
            getView().showLoading();
        }
    }

    @Override
    public void onHttpSuccess( int tag,String response) {
        if(getView()!=null){
            getView().closeLoading();
            getView().handlerView(tag,response);
        }
    }

    @Override
    public void onHttpFail(int tag,String errorMsg) {
        if(getView()!=null){

            getView().closeLoading();
            getView().handlerErrorView(tag,errorMsg);
        }

    }

    @Override
    public void onProgress(long total, long current) {

    }

    @Override
    public void onDestroy() {
       if(viewRef!=null){
           viewRef.clear();
           viewRef=null;
       }
    }
}
