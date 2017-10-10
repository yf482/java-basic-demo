package com.day13_14;

public class ReverseDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String str = "cccbbaaa";
        char[] ch = str.toCharArray();
        str = reverseArr(ch);
        System.out.println(str);

    }


    private static String reverseArr(char[] ch) {
        // TODO Auto-generated method stub

        for (int start = 0, end = ch.length - 1; start < end; start++, end--) {
            swap(ch, start, end);
        }


        return new String(ch);
    }


    private static void swap(char[] ch, int start, int end) {
        // TODO Auto-generated method stub
        char c = ch[start];
        ch[start] = ch[end];
        ch[end] = c;

    }


}
