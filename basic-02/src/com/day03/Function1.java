package com.day03;

public class Function1 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int y = 0;
        y = getResult(5);
        System.out.println(y);

    }

    //返回int类型
    public static int getResult(int num) {

        return num * 2;
    }

    //void代表函数没有具体函数返回值，return可以不写
    public static void showResult(int num) {
        System.out.println(num);
    }

    //求和函数
    public static int sumN(int x, int y) {
        return x + y;
    }

    //判断功能结果
    public static boolean compare(int a, int b) {
/*
        if(a==b)
			return true;
		else
			return false;
			*/
        //return (a==b)?ture:false;
        return a == b;
    }
}
