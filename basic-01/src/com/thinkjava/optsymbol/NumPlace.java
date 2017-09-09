package com.thinkjava.optsymbol;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc 位数操作
 * @create 2017-09-09 12:00
 **/
public class NumPlace {
    public static void main(String[] args) {
        int i = 1 & 1;
        System.out.println("i:" + i);
        int i2 = 1 & 0;
        System.out.println("i2:" + i2);
        int i3 = 1^2;
        System.out.println("i3 = " + i3);
        int i4 = ~2;
        System.out.println("i4 = " + i4);
        URShirf();

    }

    public static void URShirf(){
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        i >>>= 10;
        System.out.println(Integer.toBinaryString(i));
        long l = -1;
        System.out.println("l = " + l);
        System.out.println(Long.toBinaryString(l));
        l >>>=10;
        System.out.println(Long.toBinaryString(l));
        short st = 9;
        System.out.println(Integer.toBinaryString(st));
        byte b = 8;
        System.out.println(Integer.toBinaryString(b));
        b >>>= 10;
        System.out.println(Integer.toBinaryString(b));
        b = -1;
        System.out.println(Integer.toBinaryString(b));


    }
}
