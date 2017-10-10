package com.day06;

public class SingleDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Single s1 = Single.getInstance();
        s1.setNum(3);
        Single s2 = Single.getInstance();
        System.out.println(s2.getNum());
    }

}

class Single {
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    private Single() {
    }

    private static Single s = new Single();

    public static Single getInstance() {
        return s;
    }
}
