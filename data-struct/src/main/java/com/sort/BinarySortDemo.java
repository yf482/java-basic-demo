package com.sort;

public class BinarySortDemo {

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
            if (key > arr[mid]){
                min = mid + 1;
            }else if (key < arr[mid]){
                max = mid - 1;
            }
            if (max < min){
                return -1;
            }
            mid = (max + mid) / 2;
        }
        return mid;
    }
    /**
     *
     * @param arr
     * @param key
     * @return
     */
    public static int binarySortRecur(int[] arr, int key,int min,int max) {
        int mid = (max + min) / 2;
        if(min < 0){
            throw new RuntimeException("");
        }
        if(max < 0){
            throw new RuntimeException("");
        }
        if(min < max){
            return -1;
        }
        if(arr[mid] == key){
            return mid;
        }else if(key > arr[mid] ){
            return binarySortRecur(arr,key,mid+1,max);
        }else if(key < arr[mid]){
            return binarySortRecur(arr,key,min,mid+1);
        }
        return mid;
    }
}
