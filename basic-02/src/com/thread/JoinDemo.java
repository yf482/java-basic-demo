package com.thread;

public class JoinDemo {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        Join d = new Join();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        t2.start();
        //加入线程,t1线程运算完才继续主线程。执行权在t1
//		t1.join();
        for (int i = 0; i < 60; i++) {
            System.out.println("main...." + i);
        }
        System.out.println("over");
    }

}

class Join implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 70; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
            //临时释放执行权，让出执行权，其他线程运行。实现交替输出。
            Thread.yield();
        }
    }

}