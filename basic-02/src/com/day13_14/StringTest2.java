package com.day13_14;

/*
 * 判断最长子串
 * */
public class StringTest2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s1 = "sdfdfhellojlusaqqqoi";
        String s2 = "defaxxhellozer";
        System.out.println(getMaxString(s1, s2));

    }

    public static String getMaxString(String s1, String s2) {
        String max = "", min = "";
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = (max == s1) ? s2 : s1;
        for (int x = 0; x < min.length(); x++) {
            for (int y = 0, z = min.length() - x; z != min.length(); y++, z++) {
                String temp = min.substring(y, z);
//				System.out.println(temp);
                if (max.contains(temp))
                    return temp;
            }

        }
        return "";
    }

}
