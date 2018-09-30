package com.thinkjava.proctrl;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc IfElse
 * @create 2017-09-09 13:05
 **/
public class IfElse {
    static int result = 0;
    static void test(int testVal, int target){
        if(testVal > target)
            result = +1;
        else if(testVal < target)
            result = -1;
        else
            result = 0;
    }

    public static void main(String[] args) {
        test(10,5);
        System.out.println("result = " + result);
        test(5,10);
        System.out.println("result = " + result);
        test(5,5);
        System.out.println("result = " + result);


    }
}
