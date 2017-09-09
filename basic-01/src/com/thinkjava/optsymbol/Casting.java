package com.thinkjava.optsymbol;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc 类型转换运算
 * @create 2017-09-09 12:44
 **/
public class Casting{
    public static void main(String[] args) {
        int i = 200;
        long lng = (long)i;
        lng = i; // cast not really required
        long lng2 = (long)200;
        lng2 = 200;

        i = (int)lng; // narrowing conversion cast required
        castingNumvers();
        roundingNumbers();

    }

    public static  void castingNumvers(){
        double above = 0.7 , below = 0.4;
        float fabove = 0.7f,fbelow = 0.4f;
        System.out.println("above = " + (int)above);
        System.out.println("below = " + (int)below);
        System.out.println("fabove = " + (int)fabove);
        System.out.println("fbelow = " + (int)fbelow);


    }

    public static void roundingNumbers(){
        double above = 0.7 , below = 0.4;
        float fabove = 0.7f,fbelow = 0.4f;
        System.out.println("Math.round(above) = " + Math.round(above));
        System.out.println("Math.round(below) = " + Math.round(below));
        System.out.println("Math.round(fabove) = " + Math.round(fabove));
        System.out.println("Math.round(fbelow) = " + Math.round(fbelow));
    }
}
