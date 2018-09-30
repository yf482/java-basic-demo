package com.thread;

class Resource implements ResourceIn {
    private String name;
    private String sex;
    private boolean flag = false;

    public synchronized void set(String name, String sex) {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }

    @Override
    public void set(String name) {

    }


    public synchronized void out() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("out:" + name + "---" + sex);
        flag = false;
        this.notify();
    }



}