package com.dawn.okhttpmvp.test;


import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.BaseResult;
import com.dawn.okhttpmvp.test.response.GoodsListBean;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class MainRequest2 extends OkRequest<BaseResult<GoodsListBean>> {
    public String productId;

    public MainRequest2(int tag) {
        super(tag);
    }

    @Override
    public String getUrl() {
        return "getProductDetail";
    }

    @Override
    public HashMap<String, String> getParamMap() {
        HashMap<String,String>map=super.getParamMap();
        map.put("productId",productId);
        return map;
    }
}
