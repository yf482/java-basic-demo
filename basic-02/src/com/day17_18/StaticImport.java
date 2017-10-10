package com.day17_18;
//静态导入

import java.util.Arrays;

import static java.lang.System.out;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

//当类名重名是要指定具体的包名
//当方法重名时 ，指定具体所属的对象或者类
public class StaticImport {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {3, 4, 1};

        sort(arr);
        int index = binarySearch(arr, 1);
        out.println(Arrays.toString(arr));

    }

}
