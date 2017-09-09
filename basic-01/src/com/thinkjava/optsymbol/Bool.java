package com.thinkjava.optsymbol;

import java.util.Random;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc 逻辑表达式
 * @create 2017-09-09 11:19
 **/
public class Bool {

    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        System.out.println(i);
        System.out.println(j);
        System.out.println("i>j : " + (i>j));
        System.out.println("i<j : " + (i<j));
        System.out.println("i<=j : " + (i<=j));
        System.out.println("i>=j : " + (i>=j));
        System.out.println("i!=j : " + (i!=j));
        System.out.println("i==j : " + (i==j));
        System.out.println(((i<10) && (i==j)));
        System.out.println(((i<10) || (i==j)));


    }



}
