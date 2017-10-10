package com.day9_10;

public class DeadLock {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Thread t1 = new Thread(new LockDemo(true));
        Thread t2 = new Thread(new LockDemo(false));
        t1.start();
        t2.start();
    }

}

class LockDemo implements Runnable {
    private boolean flag;

    LockDemo(boolean flag) {
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