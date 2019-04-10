package com.threadpool;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc 】
 * @create 2018-05-15 0:58
 **/
public class TestPool {

    @Test
    public void test() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new Callable<String>() {   //接受一上callable实例
            public String call() throws Exception {
                Thread.sleep(5000);
                return "MOBIN";
            }
        });
//        String res = future.get();
        String res = future.get(3, TimeUnit.SECONDS);
        System.out.println("任务的执行结果：" + res);


    }

    public void test2() {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,10,1000,TimeUnit.SECONDS,blockingQueue);
    }

    public void test2() {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,10,1000,TimeUnit.SECONDS,blockingQueue,new ThreadPoolExecutor.AbortPolicy());
    }

    @Test
    public void test3(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);
        ScheduledExecutorService product = Executors.newScheduledThreadPool(1);
        Random random = new Random();
        product.scheduleAtFixedRate(() -> {
            int value = random.nextInt(101);
            try {
                blockingQueue.offer(value);  //offer()方法就是网队列的尾部设置值
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }, 0, 200, TimeUnit.MILLISECONDS);  //每100毫秒执行线程

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    System.out.println("开始取值");
                    List<Integer> list = new LinkedList<>();
                    blockingQueue.drainTo(list);  //drainTo()将队列中的值全部从队列中移除，并赋值给对应集合
                    list.forEach(System.out::println);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
