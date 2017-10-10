package com.basic;

public class TestStr {

    public static void main(String[] args) {
        String s = new String();
        s = "aa:11|bb:22|cc:33";
        System.out.println(s);
        String sbf = s.replace(":", ",");
        System.out.println(sbf);
        String bf = s.toString().replaceAll("\\|", ":");
        System.out.println(bf);
        String[] strs = bf.split(":");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

}
