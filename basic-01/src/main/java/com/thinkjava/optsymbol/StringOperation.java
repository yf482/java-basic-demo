package com.thinkjava.optsymbol;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc 字符串操作
 * @create 2017-09-09 12:38
 **/
public class StringOperation {
    public static void main(String[] args) {
        int x = 0,y=1,z=2;
        String s = "x,y,z ";
        System.out.println(s + x + y + z);
        System.out.println(x); //convert x to string
        s += "summed ";
        System.out.println(s);
        System.out.println("" + y);
    }
}
