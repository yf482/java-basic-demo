package com.singleton.layzyInit;

public class LayzyLoadDemo2 {

    private static LayzyLoadDemo2 instance;

    private LayzyLoadDemo2(){};

    public static  LayzyLoadDemo2 getInstance(){
        synchronized(LayzyLoadDemo2.class){
            if(instance == null){
                instance = new LayzyLoadDemo2();
            }
        }
        return instance;
    }
}
