package com.thread;

class Input implements Runnable {

    Resource r;

    public Input(Resource r) {
        this.r = r;

    }

    @Override
    public void run() {
        int x = 0;
        int y = 1;
        while (true) {
            if (x == 0) {
                r.set("mike", "男" + y);
            } else {
                r.set("lina", "女" + y);
            }
            y++;
            x = (x + 1) % 2;
        }

    }

}