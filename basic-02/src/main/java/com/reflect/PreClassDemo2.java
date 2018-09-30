package com.reflect;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-08-18 16:34
 **/
public class PreClassDemo2 {
    public static void main(String[] args) {

        Class<?> in = int.class;
        System.out.println(in);//int
        Class<?> in2 = Integer.class;
        //包装类都有一个常量TYPE，用来表示其基本数据类型的字节码
        Class<?> in3 = Integer.TYPE;

        System.out.println(in2);//class java.lang.Integer
        System.out.println(in3);//int
        System.out.println(in3 == in);//true 包装类都有一个常量TYPE，用来表示其基本数据类型的字节码，所以这里会相等！
        System.out.println(in3 == in2);//false
        Class<String[]> s = String [].class;
        Class<int[]> i = int [].class;
        //System.out.println(i ==s);//编译根本就通过不了，一个是int，一个是String
    }
    //这两个自定义的方法是可以的，一个int，一个Integer//包装类与基本数据类型的字节码是不一样的
    public void show(int i){}
    public void show(Integer i){}
}