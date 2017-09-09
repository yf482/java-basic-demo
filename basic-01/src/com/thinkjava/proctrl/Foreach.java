package com.thinkjava.proctrl;

import java.util.Random;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc foreach
 * @create 2017-09-09 13:26
 **/
public class Foreach {
    public static void main(String[] args) {
        Random random = new Random(47);
        float f[] = new float[10];
        for(int i=0; i<10;i++)
            f[i]= random.nextFloat();
        for(float x : f)
            System.out.println("x = " + x);

        ForeachStr();
    }
    static void ForeachStr(){
        for (char c : "hello world".toCharArray()){
            System.out.println("c = " + c);
        }
    }


}
