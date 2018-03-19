package com.dawn.httplib.http.handler;

import com.dawn.httplib.http.exception.HttpException;
import com.dawn.httplib.http.request.OkRequest;
import com.dawn.httplib.http.response.BaseResult;
import com.dawn.httplib.http.response.OkResponse;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;

import static com.dawn.httplib.http.exception.HttpException.JSON_ERROR_CODE;
import static com.dawn.httplib.http.exception.HttpException.JSON_ERROR_MSG;
import static com.dawn.httplib.http.exception.HttpException.RESULT_NO_ERROR_CODE;
import static com.dawn.httplib.http.exception.HttpException.SELF_ERROR_CODE;
import static com.dawn.httplib.http.exception.HttpException.SERVER_CONNECT_ERROR_CODE;
import static com.dawn.httplib.http.exception.HttpException.SERVER_ERROR_MSG;
import static com.dawn.httplib.http.exception.HttpException.SERVER_NO_ERROR_CODE;
import static com.dawn.httplib.http.exception.HttpException.SERVER_RESPONSE_NOT200_ERROR_CODE;
import static com.dawn.httplib.http.response.BaseResult.OKCODE;

/**
 * post get请求对结果的处理
 */

public class ResponseHandler {
    public static HttpException checkHttp(OkRequest request, Call call) {
        OkResponse okResponse = null;
        try {
            Response response = call.execute();
            okResponse = new OkResponse(request, response, response.body().string());
            if (response.isSuccessful()) {//httpcode==200
                return new HttpException(SERVER_NO_ERROR_CODE, "").setOkResponse(okResponse);
            } else {
                return new HttpException(SERVER_RESPONSE_NOT200_ERROR_CODE, SERVER_ERROR_MSG).setOkResponse(okResponse);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return new HttpException(SERVER_CONNECT_ERROR_CODE, SERVER_ERROR_MSG).setUrl(request.getUrl()).setHttpCode(-1).setJson("");
        }


    }

    public static HttpException checkResult(OkResponse okResponse, Type type) {
        try {
            String json = okResponse.getResultJson();
            JSONObject jsonObject = new JSONObject(json);
            String code = jsonObject.getString("code");
            String msg = jsonObject.getString("msg");
            if (OKCODE.equals(code)) {
                Gson gson = new Gson();
                BaseResult result = gson.fromJson(okResponse.getResultJson(), type);
                return new HttpException(RESULT_NO_ERROR_CODE, "").setResult(result);
            } else {
                return new HttpException(SELF_ERROR_CODE, msg).setOkResponse(okResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpException(JSON_ERROR_CODE, JSON_ERROR_MSG).setOkResponse(okResponse);
        }


    }

}
