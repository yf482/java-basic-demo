package com.singleton.hungry;

/**
 * 饿汉式：1、静态变量
 */
public class HungryLoadDemo1 {

    private static HungryLoadDemo1 instace = new HungryLoadDemo1();

    private HungryLoadDemo1(){};

    public static HungryLoadDemo1 getInstance(){
        return instace;
    }
}
