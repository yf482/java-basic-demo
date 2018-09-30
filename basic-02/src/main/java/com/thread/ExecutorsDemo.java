package com.thread;

import java.util.concurrent.*;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-01-03 22:26
 **/
public class ExecutorsDemo {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        MyThread2 myThread2 = new MyThread2();
        cachedThreadPool.execute(myThread2);


        CallPoint callPoint = new CallPoint();
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> st = exec.submit(callPoint);
        String result = null;
        try {
            result = st.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("result = " + result);

    }


}

class MyThread2 implements Runnable {
    @Override
    public void run() {

        System.out.println("MyThread2 run");

    }
}

class CallPoint implements Callable<String> {

    @Override
    public String call() throws Exception {
        try {
//            Thread.sleep(6000);
            Thread.sleep(4000);
            System.out.println("call run ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "call";
    }
}


