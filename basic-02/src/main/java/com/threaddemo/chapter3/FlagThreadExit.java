package com.threaddemo.chapter3;

import java.util.concurrent.TimeUnit;

public class FlagThreadExit {

    static class MyTHread extends Thread{
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println(" start work !");
            while(!closed && !isInterrupted()){

            }
            System.out.println(" end work !");
        }
        public void close(){
            this.closed = true;
            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTHread tHread = new MyTHread();
        tHread.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("thread will shutdown now ");
        tHread.close();
    }
}
