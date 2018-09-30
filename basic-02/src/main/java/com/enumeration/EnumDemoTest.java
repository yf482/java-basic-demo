package com.enumeration;

import org.junit.Test;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2017-12-12 22:35
 **/
public class EnumDemoTest {

    @Test
    public void test1() {
        for (EnumDemo e : EnumDemo.values()) {
            System.out.println("e = " + e.toString());
        }
        System.out.println(" ======== ");
        EnumDemo en = EnumDemo.THU;
        switch (en) {
            case MON:
                System.out.println(" mon ");
                break;
            case FRI:
                System.out.println(" mon ");
                break;
            default:
                System.out.println("de");
                break;
        }
        //判断枚举顺序 -1 0 1
        System.out.println("en = " + en.compareTo(EnumDemo.THU));
        System.out.println(en.getDeclaringClass().getName());
        System.out.println(en.name());
        System.out.println(en.ordinal());
    }

    @Test
    public void test2() {

    }
}
