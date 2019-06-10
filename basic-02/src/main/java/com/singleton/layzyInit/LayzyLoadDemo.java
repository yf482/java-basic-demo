package com.singleton.layzyInit;

public class LayzyLoadDemo {

    private static LayzyLoadDemo instance;

    private LayzyLoadDemo(){};

    public static  LayzyLoadDemo getInstance(){
        if(instance == null){
            instance = new LayzyLoadDemo();
        }
        return instance;
    }
}
