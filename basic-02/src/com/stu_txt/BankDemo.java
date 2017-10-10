package com.stu_txt;

public class BankDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

class Bank {
    private int sum;

    public void add(int n) {
        sum = sum + n;
        System.out.println("sum" + sum);
    }

}

class Cus implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

}