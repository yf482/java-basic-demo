package com.thinkjava.proctrl;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc whileTest
 * @create 2017-09-09 13:15
 **/
public class WhileTest {

    static boolean  condition(){
        boolean result = Math.random() < 0.99;
        System.out.println("result = " + result);
        return result;
    }

    public static void main(String[] args) {
        while(condition())
            System.out.println("inside while ");
        System.out.println("exit while");

        do
            System.out.println("inside while ");
        while(condition());

    }
}
