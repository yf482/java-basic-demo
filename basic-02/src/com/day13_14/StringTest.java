package com.day13_14;

/*
 * 获取字符串中最大相同子串，第一个动作，将短的那个串进项长度一次递减的子串打印。
 * "daewfaedddsswwfefe"
 * "wfaeddds"
 * 思路：
 * 1.将短的那个子串按照长度递减的方式获取到。
 * 2将没获取的去长串中判断是否包含。
 * */
public class StringTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String str = "abkkdkksskkakljkk";
        System.out.println(getSubCount2(str, "kk"));

    }

    public static int getSubCount(String str, String key) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(key)) != -1) {
            str = str.substring(index + key.length());
            System.out.println(str);
            count++;

        }
        return count;
    }

    public static int getSubCount2(String str, String key) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(key, index)) != -1) {
            index = index + key.length();
//				str=str.substring(index+key.length());
            System.out.println(str.substring(index));
            count++;

        }
        return count;
    }


}
