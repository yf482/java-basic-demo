package com.day11_12;

public class ThreadTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

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
                // TODO Auto-generated method stub
                for (int i = 0; i < 60; i++) {
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                }
            }
        };
        new Thread(r1).start();


    }

}
