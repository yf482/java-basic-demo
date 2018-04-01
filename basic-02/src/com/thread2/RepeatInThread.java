package com.thread2;

/**
 * synchronized 的重入
 *
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 12:19
 **/
public class RepeatInThread extends Thread {

    @Override
    public void run() {
        System.out.println(this.currentThread().getName());
        method1("test1");
    }

    public synchronized void method1(String name) {
        System.out.println("name = " + name);
        method2("test2");
    }

    public synchronized void method2(String name) {
        System.out.println("name = " + name);
        method3("test3");
    }

    public synchronized void method3(String name) {
        System.out.println("name = " + name);
    }

    public static void main(String[] args) {
        RepeatInThread thread = new RepeatInThread();
        Thread t1 = new Thread(thread, "t1");
        t1.start();
    }
}
