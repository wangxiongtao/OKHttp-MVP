package com.dawn.okhttpmvp.test;


import com.dawn.httplib.http.API;
import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.BaseResult;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class MainRequest extends OkRequest<BaseResult<List>> {
    public String proTypeCode;
    public String currentPageNum;
    public String pageCount;

    public MainRequest(int tag) {
        super(tag);
    }

    @Override
    public String getUrl() {
        return API.BASE_URL+"listProductByCategory";
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
