package com.day11_12;

public class ProducerConsumerDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Resource r = new Resource();
        Producer pro = new Producer(r);
        Cousumer con = new Cousumer(r);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}

class Resource {
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name) {
        //while可以再次判断
        //if值判断一次不够安全
        if (flag) {
            try {
                wait();//t1放弃资格 t2 放弃资格
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.name = name + "--" + count++;
        System.out.println(Thread.currentThread().getName() + "----生产者--" + this.name);
        flag = true;
        this.notify();
        //notify()唤醒线程池中第一个 ，有可能唤醒本身
        //notifyAll()唤醒线程池中所有，多个生产者和消费者要用这个方法
    }

    public synchronized void out() {
        if (!flag)
            try {
                wait();//t3放弃资格  t4放弃
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        System.out.println(Thread.currentThread().getName() + "----消费者------" + this.name);
        flag = false;
        this.notify();
    }
}

class Producer implements Runnable {
    private Resource res;

    Producer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            res.set("商品");
        }
    }

}

class Cousumer implements Runnable {
    private Resource res;

    Cousumer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            res.out();
        }
    }
}