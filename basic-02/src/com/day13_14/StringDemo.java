package com.day13_14;

public class StringDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //s1是一个类类型变量，“abc”是一个对象  “kk”是一个对象。下面连个s1是不同对象的引用。
        String s1 = "kk";
        s1 = "abc";
        String s3 = "abc";
        String s2 = new String("abc");
        //s1和s2的区别  在内存中s2是有两个对象，s1只有一个对象
        System.out.println(s1 == s3);
        System.out.println(s1 == s2);

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));


        String s = "abcssadf";
        System.out.println(s.length());
        System.out.println(s.charAt(3));
        System.out.println(s.indexOf("a"));
        System.out.println(s.indexOf("a", 3));
        System.out.println(s.indexOf("a", 12));
//		System.out.println(s.charAt(11));
    }

}
