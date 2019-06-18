package com.inteview.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LockDemo
 * @Description: TODO
 * @Author yunfeng
 * @Date 2019-06-18
 * @Version V1.0
 **/
public class LockDemo {

    private final static Lock lock = new ReentrantLock();

    /**
     * 下列哪种说法是错误的：
     *
     * A: lock是非公平锁
     * B: finally代码块不会抛出异常
     * C: tryLock获取锁失败则直接往下执行
     * @param args
     */
    public static void main(String[] args) {
        try {
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
