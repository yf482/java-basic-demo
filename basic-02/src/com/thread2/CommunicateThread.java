package com.thread2;

import java.util.concurrent.CountDownLatch;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 21:27
 **/
public class CommunicateThread {
    //共享可见变量
    static volatile int count = 0;
    //通过lock 机制 通知
    final static Object lock = new Object();
    //通过CountDownLatch()  参数num 是需要多少次countDownLatch.countDown(); 才可以唤醒进程
    final static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        test3();

    }

    /**
     * 通过可见共享变量课件完成进程之间的通信
     */
    public static void test1() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println("count = " + count);
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            while (true) {
                if (count == 5) {
                    System.out.println(Thread.currentThread().getName());
                    throw new RuntimeException("ddd");
                }
            }
        }, "t2");


        t1.start();
        t2.start();
    }

    /**
     * 通过可notify课件完成进程之间的通信
     */
    public static void test2() {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    count++;
                    System.out.println("count = " + count);
                    if (count == 5) {
//                        Thread.currentThread().notify();
                        System.out.println("发出通知");
                        lock.notify();
                    }
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                if (count != 5) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " - wait");
                        //wait方法释放锁
//                        Thread.currentThread().wait();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                    throw new RuntimeException("ddd");
                }
            }

        }, "t2");

        //先启动t2线程
        t2.start();
        t1.start();
    }


    /**
     * 通过可notify课件完成进程之间的通信
     */
    public static void test3() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println("count = " + count);
                if (count == 5) {
                    System.out.println("发出通知");
                    countDownLatch.countDown();
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            if (count != 5) {
                System.out.println(Thread.currentThread().getName() + " - wait");
                //wait方法释放锁
                try {
                    countDownLatch.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());

        }, "t2");

        //先启动t2线程
        t2.start();
        t1.start();
    }
}
