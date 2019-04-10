package com.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
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
        Future<String> future = executor.submit(new Callable<String>() {
            //接受一上callable实例
            public String call() throws Exception {
//                Thread.sleep(5000);
                Thread.sleep(2000);
                return "MOBIN";
            }
        });
//        String res = future.get();
        String res = future.get(3, TimeUnit.SECONDS);
        System.out.println("任务的执行结果：" + res);


    }
    @Test
    public void test2() {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,15,10l,TimeUnit.SECONDS, blockingQueue);
        for(int i=0;i<10;i++){
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("poolExecutor = " + poolExecutor);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public  void test4(){
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for(int i=0;i<10;i++){
            singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        }
        singleThreadPool.shutdown();
    }

    public void test22() {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,10,1000,TimeUnit.SECONDS,blockingQueue,new ThreadPoolExecutor.AbortPolicy());
    }

    @Test
    public void test3() {
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
