package com.day06;

public class StaticDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {5, 2, 4, 9, 4};
//		ArrayTool tool =new ArrayTool();
        System.out.println(ArrayTool.getMax(arr));

    }

}

class ArrayTool {

    //优化工具类，不能创建实例对象,私有化构造方法，让其他类不能实例化，产生无用内存。
    private ArrayTool() {
    }

    public static int getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }

        }
        return arr[max];
    }

    public static int getMin(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return arr[min];
    }

    public static void selectSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {

            for (int y = x + 1; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
                    swap(arr, x, y);
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = 0; y < arr.length - x + 1; y++) {
                if (arr[y] > arr[y + 1]) {
                    swap(arr, y, y + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }


}
