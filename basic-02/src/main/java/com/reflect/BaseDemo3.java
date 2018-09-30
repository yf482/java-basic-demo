package com.reflect;

import java.lang.reflect.Modifier;

class A {
}
interface B{
}
interface C{
}

public class BaseDemo3 extends A implements B,C{

    //内部类
    public class C{}
    public interface D{}
    public static void main(String[] args) {
        //类可以，接口也可以
        Class<BaseDemo3> c = BaseDemo3.class;
        System.out.println(c);//class junereflect624.BaseDemo3

        //得到包名
        System.out.println(c.getPackage());//package junereflect624

        //得到全限定名
        System.out.println(c.getName());//junereflect624.BaseDemo3

        //得到类的简称
        System.out.println(c.getSimpleName());//BaseDemo3

        //得到父类
        /**
         * Class<? super T> getSuperclass() 此处super表示下限
         返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class。
         */
        System.out.println(c.getSuperclass().getSimpleName());//A,先获取父类，再获取父类的简称

        //得到接口
        System.out.println(c.getInterfaces());//[Ljava.lang.Class;@1b60280
        Class[] arr = c.getInterfaces();
        for (Class cla : arr) {
            System.out.println(cla);//interface junereflect624.B   interface junereflect624.C
        }

        //获得public修饰的类
        /**
         * Class<?>[] getClasses()
         返回一个包含某些 Class 对象的数组，这些对象表示属于此 Class 对象所表示的类的成员的所有公共类和接口。 （如果内部类前面没有加上public的话那么得不到！）
         */
        Class[] cl = c.getClasses();
        System.out.println(cl.length);//在内部类没有加上public修饰的时候长度为0，加上就是2(获取的是公共的)
        for (Class class1 : cl) {
            System.out.println(class1);
        }

        //获得修饰符
        int i = c.getModifiers();
        System.out.println(i);//常量值1表示public
        System.out.println(Modifier.toString(i));//直接打印出public
    }
}