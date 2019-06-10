package com.singleton.layzyInit;

public class LayzyLoadDemo1 {

    private static LayzyLoadDemo1 instance;

    private LayzyLoadDemo1(){};

    public static synchronized LayzyLoadDemo1 getInstance(){
        if(instance == null){
            instance = new LayzyLoadDemo1();
        }
        return instance;
    }
}
