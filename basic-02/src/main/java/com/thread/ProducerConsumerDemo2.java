package com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Resource1 r = new Resource1();
        Producer1 pro = new Producer1(r);
        Cousumer1 con = new Cousumer1(r);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}

class Resource1 {
    private String name;
    private int count = 1;
    private boolean flag = false;

    private Lock lock = new ReentrantLock();
    private Condition pro = lock.newCondition();

    private Condition con = lock.newCondition();

    public void set(String name) throws InterruptedException {
        //while可以再次判断
        //if值判断一次不够安全
        lock.lock();
        try {
            while (flag)
                pro.await(); //t1放弃资格 t2 放弃资格
            this.name = name + "--" + count++;
            System.out.println(Thread.currentThread().getName() + "----生产者--" + this.name);
            flag = true;
            con.signal();
        } finally {
            lock.unlock();
        }

        //notify()唤醒线程池中第一个 ，有可能唤醒本身
        //notifyAll()唤醒线程池中所有，多个生产者和消费者要用这个方法
    }

    public synchronized void out() throws InterruptedException {
        lock.lock();
        try {
            while (!flag)
                con.await();//t3放弃资格  t4放弃
            System.out.println(Thread.currentThread().getName()
                    + "----消费者------" + this.name);
            flag = false;
            pro.signal();
        } finally {
            lock.unlock();
        }

    }
}

class Producer1 implements Runnable {
    private Resource1 res;

    Producer1(Resource1 res) {
        this.res = res;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                res.set("商品");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

class Cousumer1 implements Runnable {
    private Resource1 res;

    Cousumer1(Resource1 res) {
        this.res = res;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                res.out();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}