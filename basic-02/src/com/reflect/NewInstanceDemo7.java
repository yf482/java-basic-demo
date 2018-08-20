package com.reflect;

import java.lang.reflect.Constructor;

class Per{
    private String name;
    private int age;
    private Per(){
    }
    private Per(String name){
    }
    public String toString() {
        return "对象！！！";
    }
}

public class NewInstanceDemo7 {
    public static void main(String[] args) throws Exception {
        Class<Per> c = Per.class;
        //System.out.println(c.newInstance());;//证明利用无参的可以

        ////先获得需要被调用的构造器(private 修饰的构造方法)
        Constructor<Per> con = c.getDeclaredConstructor();//调用默认的，什么都不要写
        System.out.println(con);//private junereflect624.Per()
		/*con = c.getDeclaredConstructor(String.class);获取指定的构造方法
		System.out.println(con);//private junereflect624.Per(java.lang.String)*/
        //现在只需要执行这个构造器，
        /**
         *  T newInstance(Object... initargs)
         使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
         */

        //私有的成员是受保护的,不能直接访问
        //若要访问私有的成员,得先申请一下
        con.setAccessible(true);//允许访问
        Per p = con.newInstance();//成功，通过私有的受保护的构造方法创建了对象
        System.out.println("无参构造方法"+p);

        con = c.getDeclaredConstructor(String.class);
        System.out.println(con);//private junereflect624.Per(java.lang.String)

        con.setAccessible(true);//允许访问
        p = con.newInstance("liuzhao");//成功，通过私有的受保护的构造方法创建了对象
        System.out.println("String构造方法"+p);
    }
}
//备注：对于此时的话，单例模式就不再安全了！反射可破之！！
//复杂点的：更强大的第二种：
//
//        使用指定构造方法来创建对象:
//        获取该类的Class对象。
//        利用Class对象的getConstructor()方法来获取指定的构造方法。
//        调用Constructor的newInstance()方法创建对象。
//
//        AccessibleObject对象的setAccessible(boolean flag)方法,当flag为true的时候，就会忽略访问权限(可访问私有的成员)。
//        其子类有Field, Method, Constructor;
//        若要访问对象private的成员？
//        在调用之前使用setAccessible(true),
//        Xxx x = getDeclaredXxxx();//才能得到私有的类字段.
//
//        总结步骤：
//
//        1.获取该类的Class对象。
//        2.利用Class对象的getConstructor()方法来获取指定的构造方法。
//        3.申请访问（设置为可访问）
//        4.调用Constructor（构造方法）的newInstance()方法创建对象。