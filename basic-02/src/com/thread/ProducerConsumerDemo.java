package com.thread;

public class ProducerConsumerDemo {


    public static void main(String[] args) {

        // TODO Auto-generated method stub
        /**
         *
         *
         *
         * notify方法只能唤醒一个线程，如果本方唤醒了本方，没有意义。而且while判断标记+notify会导致死
         锁。notifyAll解决了本方线程一定会唤醒对方线程的问题
         *
         * Lock接口，出现替代同步代码块或者同步函数，将同步的隐式操作变成显示锁的操作，同事更为灵活，可以一个锁加上多组监视器。
         *
         * lock 获取锁
         * unclok:释放锁
         * condition 接口 出现替代Object中的wait、notify、notifyAll
         * await 方法对应object的wait方法
         * signal方法对应于object的notify方法
         * signalAll方法对应于object中的notifyAll
         */
//		ResourceIn r = new Resource2();
        ResourceIn r = new ResourceLock();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);

        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);

        t0.start();
        t1.start();
        t2.start();
        t3.start();

    }


}
