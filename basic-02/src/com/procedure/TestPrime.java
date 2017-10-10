package com.procedure;

public class TestPrime {

    public static void main(String[] args) {
        for (int j = 2; j <= 100; j++) {
            if (TestPrime.isPrime(j))
                System.out.println(j + "is a Prime");
        }

    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }

        }
        return true;
    }

}
