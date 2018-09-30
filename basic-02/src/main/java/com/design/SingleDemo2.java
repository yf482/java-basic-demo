package com.design;

public class SingleDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}
//记住原则，定义单例建议使用饿汉式

//懒汉式和饿汉式的区别，
class Single2 {
    private static Single2 s = null;

    private Single2() {
    }

    public static Single2 getInstance() {//调用类.getInstance方法时候才在内容中产生此类实体
        //饿汉式  需要的时候才吃
        if (s == null)
            s = new Single2();
        return s;
    }
}
