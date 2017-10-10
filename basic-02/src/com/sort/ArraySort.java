package com.sort;


import org.junit.Test;
import java.util.Arrays;

/**
 * 123aaa
 * @author v_wbyfli
 * @version 1.1
 */
public class ArraySort {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {1, 5, 2, 6, 11, 6, 12};
        printArr(arr);
        //jdk有自带排序算法
//		Arrays.sort(arr);
        bubbleSort(arr);
        printArr(arr);

//		int index = binarySort(arr,5);
        int index = Arrays.binarySearch(arr, 5);
        System.out.println(index);

        //二分查找

    }

    /**
     * 二维数组
     */
    @Test
    public void testArr() {
        int[][] arr = {{1, 2, 3}, {2, 3, 4}};
        System.out.println(arr[1].length);
        System.out.println(arr.length);
        arr[1][1] = 1;
        System.out.println(arr[1][1]);
        //二维数组遍历
    }

    /**
     * 冒泡查询
     *
     * @param arr int类型数组
     */
    public static void bubbleSort(int[] arr) {

        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = 0; y < arr.length - 1 - x; y++) {
                if (arr[y] > arr[y + 1]) {
                    int temp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = temp;
                }
            }
        }

    }

    /**
     * 二分查询
     *
     * @param arr
     * @param key
     * @return
     */
    public static int binarySort(int[] arr, int key) {

        int max, min, mid;
        min = 0;
        max = arr.length;
        mid = (max + min) / 2;
        while (arr[mid] != key) {
            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                max = mid - 1;
            if (max < min)
                return -1;
            mid = (max + mid) / 2;

        }
        return mid;

    }

    /**
     * @param arr
     */
    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int x = 0; x < arr.length; x++) {
            if (x != arr.length - 1)
                System.out.print(arr[x] + ",");
            else
                System.out.println(arr[x] + "]");

        }
    }

}
