package com.day03;

public class While {

    public static void main(String[] args) {
        int x = 1;
        //先判断条件然后执行循环体
        while (x < 5) {
            System.out.println("x=" + x++);

        }
        int y = 1;
        //do while 事先执行一次然后判断是否继续执行循环
        do {
            System.out.println("y=" + y);
            y++;
        } while (y < 3);

        //for 和 while 的区别
        for (int i = 0; i < 3; i++) {//i是局部变量
            System.out.print(i + "\t");
        }
        //System.out.println(i);

        int y1 = 0;
        while (y1 < 3) {
            System.out.println(y1);
            y1++;
        }
        System.out.println("y1====" + y1);
    }

}
