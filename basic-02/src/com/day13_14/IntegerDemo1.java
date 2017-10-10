package com.day13_14;

public class IntegerDemo1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        method();

        Integer x = 4;//自动装箱， new();
        x = x + 4;//x.intValue()自动调用

        Integer m = 128;
        Integer n = 128;
        System.out.println(m == n); //属于对象比较
        Integer a = 127;//byte类型 -128-127 不开辟空间
        Integer b = 127;
        System.out.println("a==b  " + (a == b));//true因为在byte范围内容 对于新特性，如果该数值已经存在
        //则不会再开辟空间  一般都用.equals()比较对象内容

    }

    public static void method() {
        Integer x = new Integer("123");
        Integer y = new Integer(123);
        System.out.println("x==y---" + (x == y));
        System.out.println("x.equald(y)---" + x.equals(y));
    }

}
