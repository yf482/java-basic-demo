package com.day13_14;

public class Aplues {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int a = 1;
        a++;
        a = a;
        System.out.println(a);
        //a++运算后才加1
        a = a++;
        System.out.println(a);
    }

}
