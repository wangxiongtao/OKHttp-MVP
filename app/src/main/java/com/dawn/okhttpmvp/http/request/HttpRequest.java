package com.dawn.okhttpmvp.http.request;

import com.dawn.okhttpmvp.http.HttpCallBack;
import com.dawn.okhttpmvp.http.HttpMananger;
import com.dawn.okhttpmvp.http.strategy.HttpDownload;
import com.dawn.okhttpmvp.http.strategy.HttpGet;
import com.dawn.okhttpmvp.http.strategy.HttpPost;
import com.dawn.okhttpmvp.http.strategy.HttpUpload;
import com.dawn.okhttpmvp.http.strategy.IHttpStrategy;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/10/21.
 */

public abstract class HttpRequest implements IRequest{
    public static final int GET = 1;//GET POST DOWNLOAD UPLOAD
    public static final int POST = 2;//GET POST DOWNLOAD UPLOAD
    public static final int DOWNLOAD = 3;//GET POST DOWNLOAD UPLOAD
    public static final int UPLOAD = 4;//GET POST DOWNLOAD UPLOAD
    private int tag;
    private String url;
    private String token = "http";


    public HttpRequest(int tag) {
        this.tag = tag;
    }

    public HttpRequest(int tag, String url) {
        this(tag);
        this.url = url;
    }

    public int getTag() {
        return tag;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void doPostRequest(HttpCallBack callBack) {
        IHttpStrategy http=new HttpPost();
        HttpMananger.getInstance().doRequest(http,this,callBack);
    }

    @Override
    public void doGetRequest(HttpCallBack callBack) {
        IHttpStrategy http=new HttpGet();
        HttpMananger.getInstance().doRequest(http,this,callBack);

    }

    @Override
    public void doDownloadRequest(HttpCallBack callBack) {
        IHttpStrategy http=new HttpDownload();
        HttpMananger.getInstance().doRequest(http,this,callBack);

    }

    @Override
    public void doUpLoadRequest(HttpCallBack callBack) {
        IHttpStrategy http=new HttpUpload();
        HttpMananger.getInstance().doRequest(http,this,callBack);

    }

    @Override
    public HashMap<String, String> getParamMap() {
        HashMap<String, String> hashMap = new HashMap<>();
//        try {
//            for (Field field : this.getClass().getDeclaredFields()) {
//                String type = Modifier.toString(field.getModifiers());
//                if ("public".equals(type)) {
//                    String name = field.getName();
//                    Object value = field.get(this);
//                    if (value != null && !TextUtils.isEmpty(value.toString())) {
//                        hashMap.put(name, value.toString());
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        hashMap.put("token", token);
        return hashMap;
    }


}
