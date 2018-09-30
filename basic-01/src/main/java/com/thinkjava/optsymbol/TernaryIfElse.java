package com.thinkjava.optsymbol;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc 三元操作符号
 * @create 2017-09-09 12:31
 **/
public class TernaryIfElse {
    static int ternary(int i){
        return i<10? i*100 : i*10;
    }
    static int standardIfElse(int i){
        if(i<10)
            return i*100;
        else
            return i*10;

    }

    public static void main(String[] args) {
        System.out.println(ternary(9));
        System.out.println(standardIfElse(9));
    }
}
