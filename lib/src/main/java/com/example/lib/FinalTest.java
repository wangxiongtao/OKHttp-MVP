package com.example.lib;

/**
 * Created by Administrator on 2018/2/26 0026.
 */
class H{
    int a=0;
}
public class FinalTest {
    public static void main(String[] args) {

//        System.out.println("getdata===>"+getData());
        H h=new H();
        h.a=8;
        set(h);
        System.out.println("h===>"+h.a);
        int d=0;
        set(d);
        System.out.println("d===>"+d);
        int[] aa={2,3,4};
        set(aa);
        System.out.println("aa===>"+aa[0]);
        String str="345";
        set(str);
        System.out.println("aa===>"+str);


    }
    private static void set(H h){
        h.a=300;
    }
    private static void set(int  h){
        h=9;
    }
    private static void set(int[]  h){
        h[0]=9;
    }
    private static void set(String h){
        h.concat("sss");
    }



    public static int getData() {
        int a = 0;
        try {

            a = 1 / 0;
            return a;


        } catch (Exception e) {
            System.out.println("===Exception"+e.getMessage());

            return a;
        } finally {

            System.out.println("===finally");
            return 10;

        }
    }

}
