package com.day13_14;

public class MyTrim {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String str = "   assd   ";
        p("(" + str + ")");
        str = myTrim(str);
        p("(" + str + ")");
        //int转字符串
        int a = 999;
        String ss = a + "";
        String s2 = Integer.toString(a);
    }

    public static String myTrim(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ')
            start++;

        while (start <= end && str.charAt(end) == ' ')
            end--;

        return str.substring(start, end + 1);
    }

    static void p(Object obj) {
        System.out.println(obj);
    }

}
