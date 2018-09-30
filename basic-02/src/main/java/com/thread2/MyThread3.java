package com.thread2;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 12:19
 **/
public class MyThread3 extends Thread {
    private static int num = 0;

    //    public  synchronized void printNum(String tag){
    public static synchronized void printNum(String tag) {
        try {

            if (tag.equals("a")) {
                num = 10;
                System.out.println("tag a set num over");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag not a set num over");
                Thread.sleep(1000);
            }
            System.out.println("num = " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        MyThread3 m1 = new MyThread3();
        MyThread3 m2 = new MyThread3();
        //线程run方法没有拿同样对象锁  通过把方式设置为static ，拿到的是class对象锁，就可以达到互斥了
        Thread t1 = new Thread(() -> {
            m1.printNum("a");
        });
        Thread t2 = new Thread(() -> {
            m2.printNum("b");
        });
        t1.start();
        t2.start();


    }
}
