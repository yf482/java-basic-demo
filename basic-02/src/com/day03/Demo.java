package com.day03;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("b");
        for (String x : list) {
            System.out.println(x);
        }
    }
}
