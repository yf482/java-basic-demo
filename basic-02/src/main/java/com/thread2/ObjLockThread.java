package com.thread2;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 12:19
 **/
public class ObjLockThread extends Thread {
    private int count = 5;

    //获得thread的锁 互斥关系
    public void run() {
        count--;
        System.out.println(this.currentThread().getName() + " count = " + count);
    }


    public void method(String name) {
        synchronized (this) {
            System.out.println("name = " + name);
        }
    }

    public void method2(String name) {
        synchronized (ObjLockThread.class) {
            System.out.println("name = " + name);
        }
    }

    private Object lock = new Object();

    public void method3(String name) {
        synchronized (lock) {
            System.out.println("name = " + name);
        }
    }

    public void method4(String name) {
        synchronized ("test") {
            System.out.println("name = " + name);
        }
    }


    public static void main(String[] args) {
        ObjLockThread thread = new ObjLockThread();
        Thread t1 = new Thread(thread, "t1");

    }
}
