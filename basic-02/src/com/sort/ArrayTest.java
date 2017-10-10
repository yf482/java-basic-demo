package com.sort;

/*1、大概确定设计五个函数1）初始化数组2）打印数组3）反转数组4）查找值5）查找最大值
 * 6）数组排序
 *2.主函数中进行整了运行过程流程判断，将以上功能进行封转后，进行每个函数的功能测试，
 * 全部测试完后可在主函数中调用
 *3.输入操作用switch来操作。每个选择里面进行相应的功能处理。
 *
 * */

import java.util.Scanner;

public class ArrayTest {

    /**
     * @param args
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        //int [] arr =InitialzaArray();
        int[] arr = InitialzaArray();

        boolean flag = true;
        System.out.println("请选择你要执行操作：");
        System.out.println("1.反转数组");
        System.out.println("2.查找数组");
        System.out.println("3.输出最大值");
        System.out.println("4.把数组从小到大进行排序并输出");
        System.out.println("5.退出");
        while (flag) {
            System.out.println("请输入整数1-5：");
            int x = sc.nextInt();
            if (x == 1 || x == 2 || x == 3 || x == 4 || x == 5) {

                switch (x) {
                    //反转数组
                    case 1:
                        arr = reverseArray(arr);
                        System.out.println("反转后的数组为：");
                        printArray(arr);

                        break;
                    //查找数
                    case 2:
                        System.out.println("请输入你要查找的数：");
                        int num = sc.nextInt();
                        searchArray(arr, num);
                        break;
                    //输出最大值
                    case 3:
                        int max = searchMax(arr);
                        System.out.println("数组中最大值为：" + max);
                        break;
                    //数组从小到大进行排序，然后打印
                    case 4:
                        arr = bubbleSort(arr);
                        System.out.println("冒泡排序后打印数组：");
                        printArray(arr);
                        break;
                    //退出
                    case 5:
                        flag = false;
                        System.out.println("已经退出");
                        break;
                    default:
                        break;
                }
            } else {

                System.out.println("您输入的信息有误");
                continue;
            }


        }

    }

    //初始化数组
    public static int[] InitialzaArray() {
        System.out.println("请输入数组长度：");
        int[] arr = new int[sc.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入arr[" + i + "]=");
            int x = sc.nextInt();
            arr[i] = x;
        }
        return arr;

    }

    //打印数组
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]=" + arr[i] + "  ");
        }
        System.out.println();
    }

    //查找数组中某个数第一次出现的下标
    public static void searchArray(int[] arr, int num) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                System.out.println("该数第一次出现在数组中的位置为：" + i);
                return;
            }
        }

        System.out.println("该数组中没有这个数");


    }

    //查找最大数
    public static int searchMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

        }
        return max;
    }

    //冒泡排序排列数组
    public static int[] bubbleSort(int arr[]) {

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }

        return arr;
    }

    //反转数组
    public static int[] reverseArray(int[] arr) {
        int n = arr.length - 1;
        int halfLen = n / 2;
        for (int i = 0; i <= halfLen; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i];
            arr[n - i] = temp;

        }
        return arr;
    }

}


