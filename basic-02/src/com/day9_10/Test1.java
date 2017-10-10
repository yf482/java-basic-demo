package com.day9_10;

public class Test1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int j1 = 1;
        for (int i = 5; i > 0; i -= 2) j1 *= i;
        System.out.println(j1);
        for (int i = 0; i < 5; i++) {
            for (int j = 5; i < j; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
        int a = 10;
        int b = (a++) + (++a) + (a * 10);
        System.out.println(b);
        Math.random();

        Zi z = new Zi();
        z.print();
        new Fu().print();
    }

}

interface fsace {
    int counter = 40;
}

class Fu {
    private int num;

    public void print() {
        System.out.println("fu");
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class Zi extends Fu {
    void show() {
        System.out.println(getNum() + "zi");
    }
}