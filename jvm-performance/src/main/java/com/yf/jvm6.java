package com.yf;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2017-09-10 0:56
 **/
public class jvm6 {
    private static int count;
    public static void main(String[] args) {


        //测试进入老年代对象 -XX:PretenureSizeThreshold=1024*1000 < 1024*1024 (1M)
        //参数：-Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1024000

//        Map<Integer,byte []> map = new HashMap<>();
//        for (int i = 0; i < 5; i++) {
//            //全放到tenured generation
//            byte[] b = new byte[1014 * 1024];
//        }


        //虚拟机优先把体积不大的对象数据分配到TLAB区域中，因此失去了在老年代分配的机会 -号表示禁用
        //参数：-Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000 -XX:-UseTLAB

        Map<Integer,byte []> map = new HashMap<>();
        for (int i = 0; i < 5*1024; i++) {
            //禁用TLAB后，全放到tenured generation,不然全放TLAB
            byte[] b = new byte[1024]; //1k
        }
    }

    }


