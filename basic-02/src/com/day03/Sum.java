package com.day03;

public class Sum {

    public static void main(String[] args) {
        int sum = 0;
        System.out.println("1-100的偶数和");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        System.out.println("");
        System.out.println("1-100的偶数和位：" + sum);


    }

}
