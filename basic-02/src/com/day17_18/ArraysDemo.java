package com.day17_18;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] arr = {2, 3, 4};
        System.out.println(Arrays.toString(arr));
        System.out.println(arr);


        String[] str = {"dsfd", "cc", "ddd"};

        //把数组变成集合，这样就可以用集合的思想操作数组元素。
        //集合的方法很多，数组的方法很少
        List<String> list = Arrays.asList(str);
        System.out.println(list);
        System.out.println(list.contains("cc"));
        System.out.println(list.hashCode());
        //将数组变成集合，不可以使用集合的增删方法。
        //因为数组长度固定  如果增删回产生UnsupportedOperationExcetion;

    }

}
