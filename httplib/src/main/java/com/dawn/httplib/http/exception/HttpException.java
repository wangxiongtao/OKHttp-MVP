package com.dawn.httplib.http.exception;

/**
 * Created by Administrator on 2018/1/30 0030.
 */

public class HttpException extends Exception {
    public static final String SERVER_ERROR_MSG="服务器连接失败";


    public HttpException(String message) {
        super(message);
    }
}
