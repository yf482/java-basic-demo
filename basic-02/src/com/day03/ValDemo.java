package com.day03;

import org.junit.Test;

public class ValDemo {

    public static void main(String[] args) {

        /**
         * 1Byte = 8 bit
         * 1kib = 1024 Byte
         * 1Mib = 1024 Kib
         * 1Gib = 1024 Mib
         */

        //各进制的转换问题 二进制 八进制
        //数据类型
        byte bt = 8;//1字节
        short st = 1;//2字节
        int i = 2;//4字节
        long lo = 111112324435454l;//8字节
        //不加l会报错，数字默认整数，超过长度就报错
        float ft = 12f;//4 byte
        double db = 1211111d;//8byte
        char c = 'c';//2byte


        /**
         * 数据类型：
         * 1、基本数据类型：
         * byte 、 short 、 int、long、 float、double
         * char 、 boolean
         * 2、引用数据类型
         * class、inteface
         * 数组
         *
         *
         */

        //类型转换  结果溢出
        byte bb = 3;
        bb = (byte) (bb + 201);
        System.out.println(bb);
        System.out.println((int) 'c');
        System.out.println((int) 'C');
        System.out.println(1 + 'C');


    }

    @Test
    public void test1() {
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);


        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);


        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);


    }

    @Test
    public void test2() {
        int a = 4, b = 5;
        System.out.println(4 / 5);//整数除整数结果是整数
        System.out.println((float) (4 / 5));
        System.out.println(5 % 4);
        System.out.println(-5 % 4);


    }

    @Test
    public void test4() {
//		当执行b=a++;语句时，先把a放在一个临时内存空间中，然后将a自
//		加1，再将临时内存空间中的a赋值给b，因此b还是原来的a的值，也就是3。
        int a = 4, b = 5;
        System.out.println(a++);//整数除整数结果是整数
        System.out.println(a--);
        System.out.println(++a);
        System.out.println(--a);


    }

    @Test
    public void test5() {
//		当执行b=a++;语句时，先把a放在一个临时内存空间中，然后将a自
//		加1，再将临时内存空间中的a赋值给b，因此b还是原来的a的值，也就是3。
        int a = 4, b = 5;
        int c = 1;
        c += a;
        System.out.println(c);
        c *= a;
        System.out.println(c);
        c -= a;
        System.out.println(c);
        c /= a;
        System.out.println(c);
        c %= a;
        System.out.println(c);


        short s = 3;
        s += 4;//和s = s+4不通  编译器进行类型转换
//		s = s + 4;  //编译器报错
        System.out.println(s);


    }
}
