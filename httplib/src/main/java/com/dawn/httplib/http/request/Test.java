package com.dawn.httplib.http.request;

import com.dawn.httplib.http.response.BaseResult;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Locale;

/**
 * Created by Administrator on 2018/1/31 0031.
 */

class ITest<E>{
    public Type mGenericSuperclass;
    public ITest(){
    Type genericSuperclass = getClass().getGenericSuperclass();
    if (genericSuperclass instanceof ParameterizedType) {
        mGenericSuperclass = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    } else {
        mGenericSuperclass = Object.class;
    }
}
    public  E getData() {
        String str="{\"code\":\"0000\",\"msg\":\"获取门店分类商品成功\",\"data\":[],\"action\":null}";
        String str2="{\"code\":\"0000\",\"msg\":\"获取商品详情成功\",\"data\":{\"productId\":15010021771,\"productName\":\"总统牌咸味黄油块 200g\",\"price\":\"36.89\",\"activityId\":\"\",\"activityPrice\":\"33.20\",\"proImg\":[\"http://img.quanshishequ.com/group1/M00/00/34/Cns0v1pXLb-AWsZxAABqWzxKbTU601.jpg\"],\"description\":\"\",\"stock\":20,\"cartNumber\":0,\"status\":1,\"promotionList\":[{\"name\":\"9折优惠\",\"promotionTag\":\"9折优惠\",\"activityTag\":\"\",\"color\":\"#ff873f\"}],\"storageCondition\":\"\",\"processingMethod\":\"\",\"wechatShareUrl\":\"/item/15010021771\",\"wechatShareImg\":\"http://img.quanshishequ.com/group1/M00/00/34/Cns0v1pXLb-AWsZxAABqWzxKbTU601.jpg\",\"wechatShareTitle\":\"全时生活商城\",\"wechatShareDescript\":\"￥36.89 总统牌咸味黄油块 200g\",\"productAttributeVOS\":[{\"text\":\"保质期\",\"value\":\"见包装\"},{\"text\":\"规格\",\"value\":\"200g\"},{\"text\":\"品牌\",\"value\":\"总统\"}],\"productType\":1},\"action\":null}";

//        BaseResult<E> resp = new Gson().fromJson(str2, new TypeToken<  BaseResult<E>>(){}.getType());
//        Gson gson=new Gson();
//        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get());
//
//       adapter.fromJson(str2);
        Gson gson=new Gson();
        BaseResult<E> b=gson.fromJson(str2,mGenericSuperclass);


        return b.data;
//        return new GsonResponsePasare<E>(){}.deal(str2);
    }


}

public class Test<T> {
    public class AA extends ITest<T>{

    }







    public static <T> T parseJson(Class<T> type,String jsonStr){
        Gson gson = new Gson();
        return gson.fromJson(jsonStr,type);
    }

    public static void main(String[] args) {
//        Test<BaseResult<GoodsListBean>> test=new Test<>();
//        Gson gson=new Gson();
//        System.out.print("===>"+test.new AA().mGenericSuperclass);
//        GoodsListBean b= gson.fromJson(test.getData().toString(), GoodsListBean.class);
//        System.out.print("===>"+b.productName);
//        GsonResponsePasare<Integer> g=new GsonResponsePasare<Integer>();
//        String str="{\"code\":\"0000\",\"msg\":\"获取门店分类商品成功\",\"data\":[],\"action\":null}";
//        System.out.print("===>"+g.deal(str).getClass());

        System.out.print(get(null));
        double d=45.267;

        String   str = String.format(Locale.getDefault(),"%.2f" ,d);
        System.out.print(str);



    }
    public static String get(String str){
        try {
            str.equals("ddd");
            return "true";
        }catch (Exception e){
//            e.printStackTrace();
            return "catch---------";
        }finally {
            return "finally---------";
        }
    }















//    public static class GsonResponsePasare<T> {
//        T deal(String response) {
//            Type gsonType = new TypeToken<BaseResult<T>>() {
//            }.getType();
//            BaseResult<T> commonResponse = new Gson().fromJson(response, gsonType);
////            Log.e("aaa","===>Data is : " + commonResponse.data+ "====>Class Type is : " + commonResponse.data);
//            return commonResponse.data;
//        }
//    }




}
