package com.thread2;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-05-19 13:49
 **/
public class TestPark {

    //park、unpark针对于线程的 无顺序要求   wait/notify针对于object  有顺序要求
    //使用park可以实现生产者消费者模型

    @Test
    public void test1() {

        System.out.println("true = " + true);
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100L);
                    System.out.println("我已经到达酒店");
                    LockSupport.park();
                    System.out.println("确认过眼神，我遇上对的人");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("女神已经到达酒店");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.unpark(thread);
            }
        });


        thread.start();
        thread2.start();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
