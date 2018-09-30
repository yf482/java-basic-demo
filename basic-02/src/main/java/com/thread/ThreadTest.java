package com.thread;

public class ThreadTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        new Thread() {
            public void run() {
                for (int i = 0; i < 60; i++) {
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        }.start();

        for (int i = 0; i < 60; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }

        Runnable r1 = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 60; i++) {
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        };
        new Thread(r1).start();


    }

}
