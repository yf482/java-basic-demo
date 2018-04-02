package com.thread2;

/**
 * volatile 线程共享变量
 *
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 19:12
 **/
public class VolatileThread extends Thread {
    //    private boolean isRunning = true;
    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
        System.out.println("running = " + running);
    }

    @Override
    public void run() {
        while (isRunning) {
            System.out.println("isRunning = " + isRunning);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("run ending");
    }

    public static void main(String[] args) {

        VolatileThread t1 = new VolatileThread();
        t1.start();
        try {
            Thread.sleep(1000);
            t1.setRunning(false);
            boolean is = t1.isRunning();
            System.out.println("is = " + is);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
