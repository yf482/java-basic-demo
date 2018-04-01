package com.thread2;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 12:19
 **/
public class MyThread extends Thread {
    private int count = 5;

    //获得thread的锁 互斥关系
    public void run() {
//    public synchronized void run(){
        count--;
        System.out.println(this.currentThread().getName() + " count = " + count);
    }


    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread t1 = new Thread(thread, "t1");
        Thread t2 = new Thread(thread, "t2");
        Thread t3 = new Thread(thread, "t3");
        Thread t4 = new Thread(thread, "t4");
        Thread t5 = new Thread(thread, "t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
