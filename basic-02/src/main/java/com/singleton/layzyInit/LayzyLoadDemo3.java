package com.singleton.layzyInit;

public class LayzyLoadDemo3 {

    private static LayzyLoadDemo3 instance;

    private LayzyLoadDemo3(){};

    public static LayzyLoadDemo3 getInstance(){
        if(instance == null){
            synchronized(LayzyLoadDemo3.class){
                if(instance == null){
                    instance = new LayzyLoadDemo3();
                }
            }
        }
        return instance;
    }
}
