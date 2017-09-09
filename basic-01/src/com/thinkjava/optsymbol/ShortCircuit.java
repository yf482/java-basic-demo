package com.thinkjava.optsymbol;

/**
 * @author yunfeng
 * @version V.1.0
 * @title 短路现象
 * @Desc shortCircuit
 * @create 2017-09-09 11:27
 **/
public class ShortCircuit {

    private int age;
    private String name;

    public static void main(String[] args) {
        boolean b = test1(10) && test1(11) && test1(8);
        System.out.println("b:" + b);
        boolean b2 = test1(10) || test1(11) || test1(8);
        System.out.println("b:" + b2);


    }

    public static boolean test1( int i){
        System.out.println(i);
        return i >10;

    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
