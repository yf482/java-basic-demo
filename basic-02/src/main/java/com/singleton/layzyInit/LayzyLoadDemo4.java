package com.singleton.layzyInit;

public class LayzyLoadDemo4 {

    private static volatile LayzyLoadDemo4 instance;

    private LayzyLoadDemo4(){};

    public static LayzyLoadDemo4 getInstance(){
        if(instance == null){
            synchronized(LayzyLoadDemo4.class){
                if(instance == null){
                    instance = new LayzyLoadDemo4();
                }
            }
        }
        return instance;
    }
}
