package com.thinkjava.optsymbol;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc 指数记数法 e=自然对数的记数 2.718
 * @create 2017-09-09 11:48
 **/
public class Exoponents {

    public static void main(String[] args) {
        float exFloat = 1.39e-43f; //1.39*e-43 1.39* 2.718-43
        exFloat = 1.39E-43f;
        System.out.printf("exFloat: " + exFloat);
        double exDouble = 47e47d; //'d' is optional
        double exDouble2 = 47e47; //Automatically double
        System.out.println(exDouble);
    }
}
