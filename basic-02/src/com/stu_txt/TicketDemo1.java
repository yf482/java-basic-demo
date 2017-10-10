package com.stu_txt;

public class TicketDemo1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

//		Ticket1 t1 = new Ticket1("thread1",100);
//		t1.start();
        Ticket1 t = new Ticket1(100);
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}

class Ticket1 implements Runnable {//extends Thread{
    private int num = 0;
    Object o = new Object();


    public Ticket1(int num) {
        // TODO Auto-generated constructor stub
        this.num = num;
    }

    public void run() {

        while (num > 0) {
            synchronized (o) {
                if (num > 0) {

                    System.out.println(Thread.currentThread().getName() + "---" + num--);
                }
            }
        }

    }
}  
