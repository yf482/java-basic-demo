package com.yf;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc jvm
 * @create 2017-09-09 23:52
 **/
public class jvm2 {


    public static void main(String[] args) {

        //-XX:+PrintGC -Xms5m -Xmx20m -Xmn2m -XX:SurvivorRatio=2 -XX:+UseSerialGC -XX:+PrintGCDetails

        //-XX:NewRatio=2 老年代/新生代
        //-XX:+PrintCommandLineFlags

        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory = " + maxMemory);
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory = " + freeMemory);
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("totalMemory = " + totalMemory);


        for(int i=1;i<10;i++){
            //分配了1M
            byte[] b1 = new byte[1*1024*1024];
        }

    }
}
