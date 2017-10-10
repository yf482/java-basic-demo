package com.procedure;

public class For {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //偶数和
        int sum = 0;
        for (int i = 0; i <= 100; i++) {

            if (i % 2 == 0) sum += i;

        }
        System.out.println(sum);
        //99乘法表
        for (int x = 1; x <= 9; x++) {
            for (int y = 1; y <= x; y++) {
                System.out.print(y + "*" + x + "=" + x * y + "\t");
            }
            System.out.println();

        }
        //break; 和标签跳转
        w:
        for (int x = 0; x < 3; x++) {
            q:
            for (int y = 0; y < 3; y++) {
                System.out.println(x);
                break w;
            }
        }
        //continue只能作用循环结构  继续循环。特点：结束本循环继续下次循环。

        //星号
        for (int x = 0; x < 5; x++) {
            for (int y = x; y < 5; y++) {
                System.out.print(" ");
            }
            for (int z = 0; z <= x; z++) {
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();


        }


    }

}
