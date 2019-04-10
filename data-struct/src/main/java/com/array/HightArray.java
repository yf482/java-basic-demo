package com.array;

public class HightArray {
    private long[]  a;
    private int nElems;

    public HightArray(int max){
        a = new long [max];
        nElems = 0;
    }

    public int findVlaue(long value){
        for(int i=0;i<nElems;i++){
            if(a[i] == value){
                return i;
            }
        }
        return -1;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;

    }

    public boolean delete (long value){
        int index = 0;
        for(int i=0;i<nElems;i++){
            if(value == a[i]){
                index = i;
                break;
            }
            if(i == nElems){
                return false;
            }
        }

        for(int i = index;i<nElems;i++){
            a[i] = a[i+1];
        }

        nElems -- ;
        return true;
    }

    public void display(){
        for(int i=0;i<nElems;i++){
            System.out.println("i = " + a[i]);
        }
    }
}
