package com.threadpool;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc ；
 * @create 2018-05-19 14:05
 **/
public class TestFutureTask {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Date startTime = new Date();
                System.out.println("startTime = " + startTime);
                Thread.sleep(1000L);
                Date endTime = new Date();
                System.out.println("endTime = " + endTime);
                return "OK";
            }
        };

        Callable<String> callable2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Date startTime = new Date();
                System.out.println("startTime2 = " + startTime);
                Thread.sleep(2000L);
                Date endTime = new Date();
                System.out.println("endTime2 = " + endTime);
                return "OK";
            }
        };

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<String>(callable2);


        new Thread(futureTask1).start();
        new Thread(futureTask2).start();


        String ret2 = futureTask2.get();
        System.out.println("ret2 = " + ret2);
        String ret1 = futureTask1.get();
        System.out.println("ret1 = " + ret1);

    }
}
