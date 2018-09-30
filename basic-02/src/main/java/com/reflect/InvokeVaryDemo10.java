package com.reflect;

import java.lang.reflect.Method;
//    使用反射操作对象-调用可变参数方法
//
//        要把可变参数都当做是其对应的数组类型参数;
//        如 show(XX... is)作为show(XX[] is)调用;
//
//        若可变参数元素类型是引用类型:
//        JDK内部接收到参数之后,会自动拆包取出参数再分配给该底层方法,为此我们需要把这个数组实参先包装成一个Object对象或把实际参数作为一个Object一维数组的元素再传递。
//
//        若可变参数元素类型是基本类型:
//        JDK内部接收到参数之后,不会拆包,所以可以不必再封装.不过封装了也不会错.所以建议,不管基本类型还是引用类型都使用Object[]封装一层,保证无误.
//
//        例子
//可变参数的方法调用
class VaryMethod{
    public static void show(int ...args){
        System.out.println("基本数据类型传递过来了！" + args[0]);
    }
    /*public static void show(int[] args){//这是一样的
    }*/
    public static void show(String ...args){
        System.out.println("引用数据类型传递过来了！" + args[0]);
    }

    public static void show2(Object ...args){
        System.out.println("引用数据类型传递过来了！" + args[0]);
    }
}

public class InvokeVaryDemo10 {
    public static void main(String[] args) throws Exception{
        Class<VaryMethod> c = VaryMethod.class;

        Method m = c.getMethod("show",int[].class);
        m.invoke(null,new int[]{1,2,3});
        Method m2 = c.getMethod("show",String[].class);
        //m.invoke(null,new String[]{"A","B","C"});//ERROR
        m2.invoke(null,(Object)new String[]{"A","B","C"});//YES,强转为Object类型
        m2.invoke(null,new Object[]{new String[]{"A","B","C"}});//推荐写法
        Method m3 = c.getMethod("show2",Object[].class);
        m3.invoke(null,new Object[]{new Object[]{"2","2"}});
    }
}