package com.example.lib;


import com.alibaba.fastjson.JSON;

class MyData{
    @Override
    public String toString() {
        return "mydata";
    }
}

class P<T>{


    public void setData() {
        String str="{\"code\":\"0000\",\"msg\":\"获取门店分类商品成功\",\"data\":[],\"action\":null}";
        BaseResult<T> result= JSON.parseObject(str,BaseResult.class);
        System.out.print(result.data);
    }


}

class S extends P<MyData>{


}

class V<T>{
    T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}





public class myClass {
    public static void main(String[] args) {
        S s=new S();
        s.setData();

    }


}
