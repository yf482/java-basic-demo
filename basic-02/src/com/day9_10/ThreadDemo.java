package com.day9_10;

public class ThreadDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread1 t = new Thread1();
//		t.start();//�����سǲ�ִ��run�ķ���
        t.run();//�����Ƕ�����÷��������̴߳�����û�н���
        for (int i = 1; i < 60; i++) {
            System.out.println("MainThread---" + i);
        }

    }

}

class Thread1 extends Thread {

    public void run() {
        for (int i = 1; i < 60; i++) {
            System.out.println("Thread1---" + i);
        }
    }
}
