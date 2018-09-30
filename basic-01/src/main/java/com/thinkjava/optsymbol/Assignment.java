package com.thinkjava.optsymbol;


public class Assignment {

    public static void main(String[] args) {
        Assignment ag = new Assignment();
        ag.haha();
        ag.test2();
    }

    /**
     * 对象引用了同一个地方
     */
    public void haha(){
        System.out.println("fe");

        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level =11;
        System.out.println("t1.level:" + t1.level);
        System.out.println("t2.level:" + t2.level);
        t1 = t2;
        System.out.println("t1.level:" + t1.level);
        System.out.println("t2.level:" + t2.level);
        t1.level = 13;
        System.out.println("t1.level:" + t1.level);
        System.out.println("t2.level:" + t2.level);
    }

    public void test2(){
        Letter x = new Letter();
        x.c = 'a';
        System.out.printf("1:x.c: " + x.c);
        f(x);
        System.out.printf("2:x.c:" + x.c);
    }

    static void f(Letter y){
        y.c = 'b';
    }

    class Tank{
        int level;
    }

    class Letter{
        char c;
    }
}
