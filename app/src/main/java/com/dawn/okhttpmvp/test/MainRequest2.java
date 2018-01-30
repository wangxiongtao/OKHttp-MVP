package com.dawn.okhttpmvp.test;


import com.dawn.httplib.http.API;
import com.dawn.httplib.http.request.OkRequest;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class MainRequest2 extends OkRequest {
    public String productId;

    public MainRequest2(int tag) {
        super(tag);
    }

    @Override
    public String getUrl() {
        return API.BASE_URL+"getProductDetail";
    }

    @Override
    public HashMap<String, String> getParamMap() {
        HashMap<String,String>map=super.getParamMap();
        map.put("productId",productId);
        return map;
    }
}
