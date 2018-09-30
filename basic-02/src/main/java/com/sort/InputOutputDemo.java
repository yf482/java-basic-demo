package com.sort;

public class InputOutputDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Res r = new Res();
        Output out = new Output(r);
        Input in = new Input(r);
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();
    }

}

class Res {
    private String name;
    private String sex;
    private boolean flag = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class Output implements Runnable {
    Res res;

    Output(Res res) {
        this.res = res;

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            //要同步同一对象
            //同步同一资源
            synchronized (res) {
                if (!res.isFlag())
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                System.out.println(res.getName() + "----" + res.getSex());
                res.setFlag(false);
                res.notify();
            }
        }
    }


}

class Input implements Runnable {

    Res res;

    Input(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        int x = 0;
        while (true) {
            synchronized (res) {
                if (res.isFlag())
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                if (x == 0) {
                    res.setName("mike");
                    res.setSex("man");
                } else {
                    res.setName("丽丽");
                    res.setSex("女");
                }

                x = (x + 1) % 2;
                res.setFlag(true);
                res.notify();
            }
        }
    }

}