package com.singleton.hungry;

/**
 * 饿汉式 2、静态代码块
 */
public class HungryLoadDemo2 {

    private static HungryLoadDemo2 instace ;
    static {
        instace = new HungryLoadDemo2();
    }

    private HungryLoadDemo2(){};

    public static HungryLoadDemo2 getInstance(){
        return instace;
    }
}
