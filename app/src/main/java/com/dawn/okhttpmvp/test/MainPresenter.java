package com.dawn.okhttpmvp.test;

import com.dawn.httplib.http.request.OkRequest;
import com.dawn.okhttpmvp.base.BasePresenter;
import com.dawn.okhttpmvp.mvp.IModel;
import com.dawn.okhttpmvp.mvp.IView;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class MainPresenter extends BasePresenter {
    public MainPresenter(IView view) {
        super(view);
    }

    public void getData(OkRequest request){
        IModel.getInstance().post(request,this);

    }
    public void downLoadData(OkRequest request){
        IModel.getInstance().downLoad(request,this);

    }
//    public void getData2(OkRequest request){
//        IModel.getInstance().post(request,this);
//
//    }
//    public void getData3(OkRequest request){
//        IModel.getInstance().post(request,this);
//
//    }。。。等等等一系列的网络请求或者其他的逻辑

}
