package com.array;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-01-03 23:11
 **/
public class SystemDemo {

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        int[] num2 = new int[5];
        System.arraycopy(num, 0, num2, 0, 3);
        System.out.println("num = " + arrayToString(num));
        System.out.println("num2 = " + arrayToString(num2));
    }

    public static String arrayToString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                stringBuilder.append(arr[i]);
            } else {
                stringBuilder.append(",\t").append(arr[i]);
            }
        }

        return stringBuilder.toString();
    }
}
