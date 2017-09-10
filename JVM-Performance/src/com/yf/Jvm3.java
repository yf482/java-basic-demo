package com.yf;

import java.util.Vector;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc jvm3
 * @create 2017-09-10 0:43
 **/
public class Jvm3 {

    public static void main(String[] args) {

        //-XX:+PrintGC -Xms5m -Xmx20m -Xmn2m -XX:SurvivorRatio=2 -XX:+UseSerialGC -XX:+PrintGCDetails
        //-XX:NewRatio=2 老年代/新生代
        //-XX:+PrintCommandLineFlags

        //-Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/Test.dump
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory = " + maxMemory);
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("freeMemo    ry = " + freeMemory);
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("totalMemory = " + totalMemory);

        Vector v = new Vector();
        for(int i=1;i<10;i++){
            //分配了1M
            byte[] b1 = new byte[1*1024*1024];
            v.add(b1);
        }

    }
}
