package com.dawn.okhttpmvp.test;

import com.dawn.okhttpmvp.http.API;
import com.dawn.okhttpmvp.http.request.HttpRequest;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class MainRequest extends HttpRequest {
    public String proTypeCode;
    public String currentPageNum;
    public String pageCount;

    public MainRequest(int tag) {
        super(tag, API.BASE_URL+"listProductByCategory");
    }

    @Override
    public HashMap<String, String> getParamMap() {
        HashMap<String,String>map=super.getParamMap();
        map.put("proTypeCode",proTypeCode);
        map.put("currentPageNum",currentPageNum);
        map.put("pageCount",pageCount);
        return map;
    }
}
