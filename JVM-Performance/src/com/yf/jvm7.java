package com.yf;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2017-09-10 0:56
 **/
public class jvm7 {
    public static void main(String[] args) {
        //TLAB对小对象进行性能优化
        //测试进入老年代对象 -XX:PretenureSizeThreshold=1024*1000 < 1024*1024 (1M)
        //参数：-XX:+UseTLAB -XX:+PrintTLAB -XX:TLABSize=102400 -XX:TLABRefillWasteFraction=100 -XX:-DoEscapeAnalysis
        long startTIme = System.currentTimeMillis();
        for (int i = 0; i < 1000*1000; i++) {
            //禁用TLAB后，全放到tenured generation,不然全放TLAB
            byte[] b = new byte[2]; //1k
        }
        long endTime = System.currentTimeMillis();
        System.out.println("(endTime-startTIme) = " + (endTime-startTIme));

    }

    }


