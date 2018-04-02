package com.collection;

import org.junit.Test;

import java.util.Arrays;

public class IntegerDemo1 {

    /**
     * 包装类主要用于对数据类型转换
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        method();

        Integer x = 4;//
        x = x + 4;//x.intValue()

        Integer m = 128;
        Integer n = 128;
        System.out.println(m == n);
        Integer a = 127;//byte 128-127
        Integer b = 127;
        System.out.println("a==b  " + (a == b));
        System.out.println(Long.parseLong("123"));
        System.out.println(Boolean.parseBoolean("true"));

    }

    public static void method() {
        Integer x = new Integer("123");
        Integer y = new Integer(123);
        System.out.println("x==y---" + (x == y));
        System.out.println("x.equald(y)---" + x.equals(y));
    }

    @Test
    public void method2() {

        Integer x = new Integer(22);
        String bin = Integer.toBinaryString(123);
        System.out.println(bin);

    }

    @Test
    public void method4() {
        String str = "123 s2 -7";
        char[] ch = {'c', 'a'};
        String str2 = Arrays.toString(ch);
        System.out.println(str2);
        int[] ints = {1, 2, 3, 4};
        System.out.println(Arrays.toString(ints));
    }

}

