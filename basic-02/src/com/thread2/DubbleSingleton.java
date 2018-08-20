package com.thread2;

import java.util.Random;

public class DubbleSingleton {

    private static DubbleSingleton ds;

    public static DubbleSingleton getDs() {
        if (ds == null) {
            try {
                //模拟初始化对象的准备时间...
                int sec = Math.abs(new Random().nextInt()) % 1000;
                System.out.println("sec = " + sec);
                Thread.sleep(sec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*synchronized (DubbleSingleton.class) {
                if (ds == null) {
                    ds = new DubbleSingleton();
                }
            }*/
            ds = new DubbleSingleton();
        }
        System.out.println("ds = " + ds);
        return ds;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getDs().hashCode());
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getDs().hashCode());
            }
        }, "t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getDs().hashCode());
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();

    }

}
