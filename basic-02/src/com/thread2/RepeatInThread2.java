package com.thread2;

/**
 * synchronized 的重入
 *
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 12:19
 **/
public class RepeatInThread2 {

    static class Parent {
        int i = 10;

        public synchronized void operationSup() {
            i--;
            System.out.println("p i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Child extends Parent {
        int i = 10;

        public synchronized void operationSub() {
            i--;
            System.out.println("c i = " + i);
            try {
                Thread.sleep(100);
                this.operationSup();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Child child = new Child();
            for (int i = 0; i < 5; i++) {
                child.operationSub();
            }
        });
        t1.start();
    }
}
