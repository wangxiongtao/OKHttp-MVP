package com.dawn.okhttpmvp.test;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dawn.httplib.http.response.BaseResult;
import com.dawn.okhttpmvp.R;
import com.dawn.okhttpmvp.base.BaseActivity;
import com.dawn.okhttpmvp.base.BasePresenter;
import com.dawn.okhttpmvp.test.response.GoodsListBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends BaseActivity {
    public static final int REQUEST_TAG1=1;
    public static final int REQUEST_TAG2=2;

    MainPresenter presenter;
    private TextView t1,t2;
    ProgressBar progressBar;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        progressBar=findViewById(R.id.pbar);


//        TTest<Integer> t=new TTest<>();
//        Log.i("aaa","====>"+t.getData().toString());
//        t1.setText(t.getData().toString());
//       P<Integer>p=new P<>();
//
//        Log.i("aaa","====>"+p.getData());
//        t1.setText(p.getData().toString());

    }

    @Override
    protected BasePresenter initPresenter() {
        presenter=new MainPresenter(this);
        return presenter;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }



    @Override
    public void handlerView(int tag, Object data) {
        switch (tag){
            case REQUEST_TAG1:
//                int  bean=Integer.parseInt(data.toString());
                t1.setText(data.toString());
                break;
            case REQUEST_TAG2:
//                Gson gson=new Gson();
//                BaseResult<GoodsListBean>result= gson.fromJson(data.toString(),BaseResult.class);
                GoodsListBean goodsListBean= (GoodsListBean) data;
                t2.setText(((GoodsListBean) data).productName);
                break;

        }


    }

    @Override
    public void handlerdownload(int tag, long total, long current, int percent) {
        super.handlerdownload(tag, total, current, percent);
        Log.i("aaa","tag=====>"+tag+"==handlerdownload===>"+total+"=====>"+current+"=====percent==>"+percent);
        progressBar.setMax(100);
        progressBar.setProgress(percent);
    }

    public void onClick(View v){
        MainRequest request=new MainRequest(REQUEST_TAG1);
        request.proTypeCode="101";
        request.currentPageNum="1";
        request.pageCount="10";

        DownLoadRequest request1=new DownLoadRequest();
        request1.setDownLoadDir(Environment.getExternalStorageDirectory()+ File.separator+"test");
        request1.setFileName("kaochao.apk");

        presenter.downLoadData(request1);


        MainRequest2 request2=new MainRequest2(REQUEST_TAG2);
        request2.productId="15010021771";
        presenter.getData(request2);
    }



    class MyData{
        @Override
        public String toString() {
            return "mydata";
        }
    }

    class P<T>{
        T result;



        public  T getData() {
            String str="{\"code\":\"0000\",\"msg\":\"获取门店分类商品成功\",\"data\":[],\"action\":null}";
            Gson gson = new Gson();
            Type jsonType = new TypeToken<BaseResult<T>>() {
            }.getType();
            BaseResult<T> r=gson.fromJson(str, jsonType);
            return r.data;
        }


    }

    class S extends P<List>{


    }






































}
