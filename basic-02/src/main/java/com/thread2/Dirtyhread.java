package com.thread2;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-04-01 12:19
 **/
public class Dirtyhread extends Thread {
    private String username = "liyunfeng";
    private String password = "123";

    public synchronized void setValue(String username, String password) {
        try {

            this.username = username;
            Thread.sleep(1000);
            this.password = password;
            System.out.println("username = " + username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getValue(String username) {
//    public  synchronized void getValue(String username){
        System.out.println("password = " + password);
    }


    public static void main(String[] args) {

        Dirtyhread m1 = new Dirtyhread();
        //不同线程执行有同一个锁不同方法
        Thread t1 = new Thread(() -> {
            m1.setValue("liyunfeng", "wall");
        });
        Thread t2 = new Thread(() -> {
            m1.getValue("liyunfeng");
        });
        t1.start();
        t2.start();


    }
}
