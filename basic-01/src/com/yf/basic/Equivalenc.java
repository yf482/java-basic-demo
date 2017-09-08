package com.yf.basic;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc equal
 * @create 2017-09-09 0:06
 **/
public class Equivalenc {
    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
        System.out.println(n1.equals(n2));
    }

    public void equalMethod(){
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        //false hashCode
        System.out.println(v1.equals(v2));
    }
    class Value{
        int i ;
    }
}
