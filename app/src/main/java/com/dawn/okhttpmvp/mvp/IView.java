package com.dawn.okhttpmvp.mvp;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public interface IView {

     void showLoading();

     void closeLoading();


     void handlerView(int tag, Object data);

     void handlerErrorView(int tag, Object data);




}
