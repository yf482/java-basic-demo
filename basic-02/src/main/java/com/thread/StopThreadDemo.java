package com.thread;

public class StopThreadDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        StopThread st = new StopThread();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);

        //守护进程
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        int num = 0;
        while (true) {
            if (num++ == 60) {
                t1.interrupt();
                t2.interrupt();
//				st.setFlag(false);
                break;
            }
            System.out.println(Thread.currentThread().getName() + "---num---" + num);
        }
        System.out.println("over");
    }

}

class StopThread implements Runnable {

    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public synchronized void run() {

        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "---Exception");
                flag = false;
            }
            System.out.println(Thread.currentThread().getName() + "---run");
        }

    }

}
