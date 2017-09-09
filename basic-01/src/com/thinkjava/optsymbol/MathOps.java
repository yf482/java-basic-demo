package com.thinkjava.optsymbol;

import java.util.Random;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc 运算符
 * @create 2017-09-08 23:43
 **/
public class MathOps {

    public static void main(String[] args) {
        Random random = new Random(47);
        int i,j,k;
        j = random.nextInt(100) + 1;
        System.out.printf("j:" + j);
        k = random.nextInt(100) + 1;
        i = j + k;
        i = j - k;
        i = k/j;
        i = k*j;
        i = k%j;
        j %=k;
        float u,v,w;
        v = random.nextFloat();
        w = random.nextFloat();
        u = v+w;
        u = v-w;
        u = v*w;
        u = v/w;
        u += w;
        u -= w;
        u *= w;
        u /= v;


    }
}
