package com.thread2.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile修饰变量 只有线程可见性 不具备原子性 需要原子性青使用Atomic类
 * Atomic类只能保证本身方法的原子性，不保证多个方法的原子性
 *
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 19:12
 **/
public class VolatileThread2 extends Thread {
    //    private statiproxy volatile int count = 0;
    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        test1();
    }

    public void test1() {
        for (int i = 0; i < 1000; i++) {
//            count++;
            count.incrementAndGet();
        }
        //打印的变量有可能不是1000备注，有延迟，只保证变量设置可见
        System.out.println("count = " + count);
    }

    //Atomic类只能保证本身方法的原子性，不保证多个方法的原子性
    public void test2() {
        for (int i = 0; i < 1000; i++) {
            count.addAndGet(1);
            count.addAndGet(2);
            count.addAndGet(3);
            count.addAndGet(4);
        }
        //打印的变量有可能不是1000备注，有延迟，只保证变量设置可见
        System.out.println("count = " + count);
    }

    public static void main(String[] args) {

        VolatileThread2[] thread2s = new VolatileThread2[20];
        for (int i = 0; i < 20; i++) {
            thread2s[i] = new VolatileThread2();
        }
        for (int i = 0; i < 20; i++) {
            thread2s[i].start();
        }

    }
}
