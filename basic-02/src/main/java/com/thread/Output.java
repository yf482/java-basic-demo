package com.thread;


class Output implements Runnable {

    Resource r;

    public Output(Resource r) {
        this.r = r;

    }

    @Override
    public void run() {
        while (true) {
            r.out();
        }

    }

}