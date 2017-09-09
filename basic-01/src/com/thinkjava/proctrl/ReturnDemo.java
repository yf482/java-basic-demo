package com.thinkjava.proctrl;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc return
 * @create 2017-09-09 13:33
 **/
public class ReturnDemo {

    static int test(int testval ,int target){
        if(testval > target)
            return +1;
        else if(testval < target)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(test(10,5));
        System.out.println(test(5,5));
        System.out.println(test(5,10));
    }
}
