package com.thread;

public class Consumer implements Runnable {

    //	private Resource2 r;
    private ResourceIn r;

    public Consumer(ResourceIn r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.out();
        }
    }

}
