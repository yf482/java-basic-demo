package com.yf;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2017-09-10 0:56
 **/
public class StackOver {
    private static int count;
    public static void main(String[] args) {
        //-Xss1m 线程调用深度
        try {
            recursion();
        }catch (Throwable t){
            System.out.println("调用的最大深度：" + count);
            t.printStackTrace();
        }

    }

    public static void recursion(){
        count++;
        recursion();
    }
}
