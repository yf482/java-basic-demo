package com.design;

public class MainFunction {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(args);
        String arr[] = {"1", "haha ", "dddd", "eee"};
        MainTest.main(arr);
    }

}

class MainTest {
    public static void main(String args[]) {
        System.out.println(args);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

}
