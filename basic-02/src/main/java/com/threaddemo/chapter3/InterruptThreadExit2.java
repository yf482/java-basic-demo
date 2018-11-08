package com.threaddemo.chapter3;

import java.util.concurrent.TimeUnit;

public class InterruptThreadExit2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run(){
                System.out.println("i will start work!");
                for(;;){
                    try {
                        System.out.println(" sleep 1 second!");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
//                    e.printStackTrace();
                        break;
                    }
                }
                System.out.println("i will be exiting.");
            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("system will be shutdown");
        t.interrupt();
    }


}
