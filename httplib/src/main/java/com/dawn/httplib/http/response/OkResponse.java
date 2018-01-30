package com.dawn.httplib.http.response;

import com.dawn.httplib.http.request.OkRequest;

import okhttp3.Headers;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/1/30 0030.
 */

public class OkResponse {
    private Response response;
    private String resultJson;
    private OkRequest request;

    public OkResponse(OkRequest request, Response response, String resultJson) {
        this.response = response;
        this.resultJson = resultJson;
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public String getResultJson() {
        return resultJson;
    }

    @Override
    public String toString() {
        return "\n            "
                + "\n请求Url==>" + this.response.request().url()
                + "\n请求参数==>" + this.request.getParamMap()
                + getHeadString()
                + "\n请求Tag==>" + this.response.request().tag()
                + "\n响应结果==>" + this.resultJson;

    }

    private String getHeadString() {
        Headers headers = this.response.request().headers();
        StringBuilder builder = new StringBuilder();
        for (int i = 0, count = headers.size(); i < count; i++) {
            builder.append("\n").append("请求头信息：").append(headers.name(i)).append("==>").append(headers.value(i));

        }
        return builder.toString();

    }
}
