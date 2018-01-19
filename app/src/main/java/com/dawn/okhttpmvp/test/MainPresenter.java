package com.dawn.okhttpmvp.test;

import com.dawn.okhttpmvp.base.BasePresenter;
import com.dawn.okhttpmvp.http.request.HttpRequest;
import com.dawn.okhttpmvp.mvp.IModel;
import com.dawn.okhttpmvp.mvp.IView;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class MainPresenter extends BasePresenter {
    public MainPresenter(IView view) {
        super(view);
    }

    public void getData(HttpRequest request){
        IModel.getInstance().post(request,this);

    }

}
