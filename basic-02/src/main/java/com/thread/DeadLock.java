package com.thread;

public class DeadLock {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Thread t1 = new Thread(new LockDemo2(true));
        Thread t2 = new Thread(new LockDemo2(false));
        t1.start();
        t2.start();
    }

}

class LockDemo2 implements Runnable {
    private boolean flag;

    LockDemo2(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        if (flag) {
            while (true) {
                synchronized (Lock.a) {
                    System.out.println("if lockA");

                    synchronized (Lock.b) {
                        System.out.println("if lockB");
                    }
                }

            }
        } else {
            while (true) {
                synchronized (Lock.b) {
                    System.out.println("else lockB");

                    synchronized (Lock.a) {
                        System.out.println("else lockA");
                    }
                }
            }

        }
    }

}

class Lock {
    static Lock a = new Lock();
    static Lock b = new Lock();
}