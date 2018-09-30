package com.reflect;

import java.lang.reflect.Method;

class Dept{
    public String show(String name){//用反射的方法来调用正常的方法
        return name+"，您好！";
    }

    private void privateshow(){//用反射来实现对私有化方法的调用
        System.out.println("privateshow");
    }

    public static void staticshow(){
        System.out.println("staticshow");
    }
}

public class InvokeDemo9 {
    public static void main(String[] args) throws Exception {

/*	传统方式：
String name = new Dept().show("刘昭");
		System.out.println(name);*/

/**
 * Method getMethod(String name, Class<?>... parameterTypes)
 返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指			定公共成员方法。
 name - 方法名
 parameterTypes - 参数列表
 */
        //想要通过反射来调用Dept中的方法
        Class<Dept> c = Dept.class;
        Method m = c.getMethod("show", String.class);
        Object o = m.invoke(c.newInstance(), "刘昭");
        System.out.println(o);

        //私有化的方法
        m = c.getDeclaredMethod("privateshow");//无参方法
        m.setAccessible(true);
        o = m.invoke(c.newInstance());

        //静态方法的调用
        m = c.getMethod("staticshow");
        m.invoke(null);//staticshow为静态方法，不需创建对象，所以这里会是null
    }
}

//7、使用反射调用方法
//
//    每个Method的对象对应一个具体的底层方法。获得Method对象后，程序可以使用Method里面的invoke方法来执行该底层方法。
//    Object invoke(Object obj,Object ... args):obj表示调用底层方法的对象，后面的args表示传递的实际参数。
//    如果底层方法是静态的，那么可以忽略指定的 obj 参数。该参数可以为 null,想想为什么?
//    如果底层方法所需的形参个数为 0，则所提供的 args 数组长度可以为 0 或 null。
//    不写,null,或 new Object[]{}
//    若底层方法返回的是数组类型,invoke方法返回的不是底层方法的值,而是底层方法的返回类型;