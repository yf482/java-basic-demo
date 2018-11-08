package com.threaddemo.chapter3;

import java.util.concurrent.TimeUnit;

public class InterruptThreadExit {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run(){
                System.out.println("i will start work!");
                while(!isInterrupted()){

                }
                System.out.println("i will be exiting.");
                if(isInterrupted()){
                    System.out.println(" interrupt end ");
                }
            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("system will be shutdown");
        t.interrupt();
    }


}
