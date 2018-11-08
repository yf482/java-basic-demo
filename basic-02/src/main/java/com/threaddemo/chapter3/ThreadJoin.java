package com.threaddemo.chapter3;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = IntStream.range(1,3).mapToObj(ThreadJoin::create).collect(Collectors.toList());

        threadList.forEach(Thread::start);
        for (Thread thread : threadList){
            thread.join();
        }
        //main 循环输出
        for(int i =0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + "_#_" +i);
            shortSleep();
        }
    }

    private static Thread create(int seq){
        return new Thread(()->{
            for(int i =0;i<10;i++){
                System.out.println(Thread.currentThread().getName() + "_#_" +i);
                shortSleep();
            }
        });
    }

    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
