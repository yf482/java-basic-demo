package com.fto;

public class InnerClassDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}

abstract class ABSDemo {
    abstract void show();
}

class Outer2 {
    int x = 3;

    //有名内部类。
    class Inner2 extends ABSDemo {
        void show() {
            System.out.println("show:x=" + x);
        }
    }

    public void function() {
        //匿名内部类相当于实现abstract类和方法相当于 new 抽象类｛实现方法｝；相当于创建了一个实体类
        new ABSDemo() {

            @Override
            void show() {
                System.out.println("show:x=" + x);
            }

        }.show();
    }
}
