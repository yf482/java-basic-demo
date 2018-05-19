package com.thread;

public class SynchronizedDemo {

    public synchronized void test1(){
        System.out.println("true = " + true);
    }

    public void test2(){
        synchronized (this){
            System.out.println("true = " + true);
        }
    }
    public synchronized static void test3(){
        System.out.println("true = " + true);
    }
}
