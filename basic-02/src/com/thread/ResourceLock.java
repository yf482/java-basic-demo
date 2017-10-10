package com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceLock implements ResourceIn {

    private String name;
    private int count = 1;
    private boolean flag = false;
    //创建一个锁对象
    Lock lock = new ReentrantLock();

    //通过已有的锁获取该所的监视对象
    Condition con = lock.newCondition();

    public void set(String name) {
        lock.lock();
        try {
            while (flag) {
                try {
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name + count;
            count++;
            System.out.println(Thread.currentThread().getName() + "--生产者" + this.name);
            flag = true;
            con.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void out() {
        lock.lock();
        try {
            while (!flag) {
                try {
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = false;
            con.signalAll();
            System.out.println(Thread.currentThread().getName() + "---消费者---" + this.name);
        } finally {
            lock.unlock();
        }
    }


}
