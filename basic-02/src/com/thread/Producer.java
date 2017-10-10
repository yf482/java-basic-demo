package com.thread;

public class Producer implements Runnable {

    private ResourceIn r;

    Producer(ResourceIn r) {
        this.r = r;
    }


    @Override
    public void run() {
        while (true) {
            r.set("烤鸭");
        }
    }

}
