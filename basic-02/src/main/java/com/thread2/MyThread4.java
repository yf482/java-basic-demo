package com.thread2;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 12:19
 **/
public class MyThread4 extends Thread {
    private static int num = 0;

    public synchronized void printNum(String tag) {
        try {

            num = 10;
            System.out.println("tag a set num over");
            Thread.sleep(1000);
            System.out.println("num = " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void printNum2(String tag) {
//    public   void printNum2(String tag){
        try {

            num = 20;
            System.out.println("tag = " + tag);
            System.out.println("num = " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        MyThread4 m1 = new MyThread4();
        //不同线程执行有同一个锁不同方法
        Thread t1 = new Thread(() -> {
            m1.printNum("a");
        });
        Thread t2 = new Thread(() -> {
            m1.printNum2("b");
        });
        t1.start();
        t2.start();


    }
}
