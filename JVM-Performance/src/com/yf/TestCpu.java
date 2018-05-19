package com.yf;

/**
 * 找出cpu消耗大的线程  分析步骤  top -H 查找消耗cpu最大的进程pid，  top -Hp  pid 查找该进程下子线程  找出消耗最大的线程pid
 * 将十进制的 pid转换为十六进制，  通过jstack  主线程pid  命令查找该线程子线程nid
 * "runThread" #9 prio=5 os_prio=0 tid=0x00007f45dc0ca800 nid=0x4ef runnable [0x00007f45cb035000]
 * java.lang.Thread.State: RUNNABLE
 * at TestCpu$2.run(TestCpu.java:32)
 * at java.lang.Thread.run(Thread.java:745)
 *
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-05-19 14:50
 **/
public class TestCpu {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " sleep! ");
                    Thread.sleep(1000000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int i = 1000 / 2;
                }
            }
        });
        for (int i = 0; i < 10; i++) {
            thread.setName("sleepThread" + i);
            thread.start();
        }
        thread2.setName("runThread");
        thread2.start();

    }
}
