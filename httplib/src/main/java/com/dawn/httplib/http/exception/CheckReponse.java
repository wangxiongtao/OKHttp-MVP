package com.dawn.httplib.http.exception;

import org.json.JSONObject;

/**
 * Created by Administrator on 2018/1/30 0030.
 */

public class CheckReponse {
    public static HttpException check(String response) throws Exception {
            JSONObject object = new JSONObject(response);
            String code = object.getString("code");
            String msg = object.getString("msg");
            return "0000".equals(code) ? null : new HttpException(msg);

    }

}
