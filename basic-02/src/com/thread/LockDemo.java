package com.thread;

public class LockDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ResourceLock r = new ResourceLock();

        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
    }

}
