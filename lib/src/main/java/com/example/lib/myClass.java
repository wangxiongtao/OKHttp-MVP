package com.example.lib;


class MyData{
    @Override
    public String toString() {
        return "mydata";
    }
}

class P<T>{


    public void setData() {

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
//        fun(0);
        fun(1);

    }

    public static void fun(int i){
        if(i==0){
            throw  new NullPointerException();
        }
        System.out.print("=====hahahhahaa====");
    }


}
