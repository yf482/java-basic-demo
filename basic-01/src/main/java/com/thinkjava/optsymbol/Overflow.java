package com.thinkjava.optsymbol;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc 溢出
 * @create 2017-09-09 12:55
 **/
public class Overflow {
    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println("big = " + big);
        System.out.println("big = " + (big +1) ) ;

        int min = Integer.MIN_VALUE;

        System.out.println("min = " + min);
        System.out.println("min = " + (min - 1));

    }
}
