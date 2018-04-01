package com.thread2;

/**
 * synchronized 异常处理
 *
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 12:19
 **/
public class ExceptionThread extends Thread {

    @Override
    public void run() {
        System.out.println(this.currentThread().getName());
        method1("test1");
    }

    public synchronized void method1(String name) {
        int i = 1;
        while (true) {

            try {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(100);
                if (i % 10 == 0) {
                    Integer.parseInt("a");
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

        }

    }


    public static void main(String[] args) {
        ExceptionThread thread = new ExceptionThread();
        Thread t1 = new Thread(thread, "t1");
        t1.start();
    }
}
