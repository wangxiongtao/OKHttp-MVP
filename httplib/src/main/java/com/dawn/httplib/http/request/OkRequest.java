package com.dawn.httplib.http.request;


import com.dawn.httplib.http.HttpCallBack;
import com.dawn.httplib.http.HttpMananger;
import com.dawn.httplib.http.strategy.HttpDownload;
import com.dawn.httplib.http.strategy.HttpGet;
import com.dawn.httplib.http.strategy.HttpUpload;
import com.dawn.httplib.http.strategy.IHttpStrategy;
import com.dawn.httplib.http.strategy.rx.HttpPostRx;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/10/21.
 */

public abstract class OkRequest<T> implements IRequest {
    private final Type mGenericSuperclass;
    T t;
    public static final int GET = 1;//GET POST DOWNLOAD UPLOAD
    public static final int POST = 2;//GET POST DOWNLOAD UPLOAD
    public static final int DOWNLOAD = 3;//GET POST DOWNLOAD UPLOAD
    public static final int UPLOAD = 4;//GET POST DOWNLOAD UPLOAD
    private int tag=-1;
    private String downLoadDir;//下载目录
    private String fileName;//下载的文件名



    public OkRequest(int tag) {
        this();
        this.tag = tag;

    }

    public void setDownLoadDir(String downLoadDir) {
        this.downLoadDir = downLoadDir;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDownLoadDir() {
        return downLoadDir;
    }

    public String getFileName() {
        return fileName;
    }

    public OkRequest() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            mGenericSuperclass = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        } else {
            mGenericSuperclass = Object.class;
        }
    }

    public Type getmGenericSuperclass() {
        return mGenericSuperclass;
    }

    @Override
    public int getTag() {
        return tag;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public void doPostRequest(HttpCallBack callBack) {
        HttpPostRx http = new HttpPostRx();

        HttpMananger.getInstance().doRequest(http, this, callBack);

    }


    @Override
    public void doGetRequest(HttpCallBack callBack) {
        IHttpStrategy http = new HttpGet();
        HttpMananger.getInstance().doRequest(http, this, callBack);

    }

    @Override
    public void doDownloadRequest(HttpCallBack callBack) {
        IHttpStrategy http = new HttpDownload();
        HttpMananger.getInstance().doRequest(http, this, callBack);

    }

    @Override
    public void doUpLoadRequest(HttpCallBack callBack) {
        IHttpStrategy http = new HttpUpload();
        HttpMananger.getInstance().doRequest(http, this, callBack);

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
        hashMap.put("token", "");
        return hashMap;
    }


}
