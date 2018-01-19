package com.dawn.okhttpmvp.test;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dawn.okhttpmvp.R;
import com.dawn.okhttpmvp.base.BaseActivity;
import com.dawn.okhttpmvp.base.BasePresenter;

public class MainActivity extends BaseActivity {
    public static final int REQUEST_TAG1=1;
    public static final int REQUEST_TAG2=2;

    MainPresenter presenter;
    private TextView t1,t2;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);

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
                t1.setText(data.toString());
                break;
            case REQUEST_TAG2:
                t2.setText(data.toString());
                break;

        }


    }

    @Override
    public void handlerErrorView(int tag, Object data) {

    }

    public void onClick(View v){
        MainRequest request=new MainRequest(REQUEST_TAG1);
        request.proTypeCode="101";
        request.currentPageNum="1";
        request.pageCount="10";
        presenter.getData(request);


        MainRequest2 request2=new MainRequest2(REQUEST_TAG2);
        request2.productId="15010021771";
        presenter.getData(request2);
    }
}
