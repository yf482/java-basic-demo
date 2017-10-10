package com.thread;

public class ProducerDemo {

    public static void main(String[] args) {

        Resource r = new Resource();
        Input in = new Input(r);
        Output out = new Output(r);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        t1.start();
        t2.start();

    }
}


	
	

