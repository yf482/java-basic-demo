package com.thread;

public class Resource2 implements ResourceIn {
    private String name;
    private int count = 1;
    private boolean flag = false;


    public synchronized void set(String name) {
        //while(!flag){
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + count;
        count++;
        System.out.println(Thread.currentThread().getName() + "--生产--" + this.name);
        flag = true;
        //notifyAll()
        notify();

    }


    public synchronized void out() {
        //while(!flag){
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
        //notifyAll()
        notify();
        System.out.println(Thread.currentThread().getName() + "-----消费---" + this.name);

    }


}
