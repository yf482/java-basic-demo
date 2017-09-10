package com.yf;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2017-09-10 0:56
 **/
public class jvm5 {
    private static int count;
    public static void main(String[] args) {
        //初始的对象在eden区
        //参数：-Xmx64M -Xms64M -XX:+PrintGCDetails


        for (int i = 0; i < 5; i++) {
            byte[] b = new byte[1014 * 1024];
        }

        //测试进入老年代对象
        //参数：-Xmx1024M -Xms1024M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:MaxTenuringThreshold=15

        for (int i = 0; i < 8000; i++) {
            byte[] b = new byte[1014 * 1024];
        }
    }

    }


