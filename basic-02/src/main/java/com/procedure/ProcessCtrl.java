package com.procedure;

import org.junit.Test;

public class ProcessCtrl {


    @Test
    public void testIf() {
        int i = 1;
        int c = 'c';
        Integer in = new Integer(1);
        if (i == 1)
            System.out.println("abc");
        else
            System.out.println("i not 1");


        if (in == null) {
            System.out.println("abc");
        } else {
            System.out.println("not null");
        }

        if (c == 'c') {
            System.out.println("abc1");
        } else if (c == 'a') {
            System.out.println("abc2");
        } else if (c == 'b') {
            System.out.println("abc3");
        } else {
            System.out.println("abc3");
        }
    }

    @Test
    public void testFor() {
        //break; 跳出当前循环
        //continue 返回循环

    }

    @Test
    public void testDoWhile() {
        //break; 跳出当前循环
        //continue 返回循环

    }

    @Test
    public void testWhile() {
        //break; 跳出当前循环
        //continue 返回循环

    }

    @Test
    public void testCase() {
        //break; 跳出当前循环
        //continue 返回循环

    }

}
