package com.io;

public class ParamMethodDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		可变参数新特性是，将这些参数封装成了数组。
        int[] arr = {2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};
        show(arr);
        show(arr2);
        show2(2, 3, 4, 5, 6);
        show2(2, 3, 4, 5, 6, 5, 3);
        show2();


    }


    public static void show(int[] arr) {
        System.out.println(arr.length);
    }

    public static void show2(int... arr) {
        System.out.println(arr.length);
    }

    //可变参数要放在参数最后面,不然会有冲突
    public static void show3(String str, int... arr) {
        System.out.println(arr.length);
    }
}
