package com.reflect;

import java.lang.reflect.Field;

class Cat{
    private String name;
    public int age;
    private String color;
}

public class FieldDemo12 {
    public static void main(String[] args) throws Exception {
        Class<Cat> clz = Cat.class;
        Field[] f = clz.getDeclaredFields();

        for (Field field : f) {
            System.out.println(field);
        }

        Field fi = clz.getDeclaredField("name");
        System.out.println(fi);

        System.out.println(fi.getName());//name

        //核心开始
        /**
         *  void set(Object obj, Object value)
         将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
         */
        Cat c = clz.newInstance();
        fi.setAccessible(true);
        fi.set(c, "刘昭");//赋值成功
        Object o = fi.get(c);
        System.out.println(o);//取出成功

        fi = clz.getDeclaredField("age");
        fi.setAccessible(true);
        fi.set(c, 21);
        int i = fi.getInt(c);//左边的接受类型已经写成了int，右边的返回类型就也必须是int
        System.out.println(i);//获取成功
    }
}
//        使用反射操作字段
//        Field提供两组方法操作字段：
//        xxx getXxx(Object obj):获取obj对象该Field的字段值，此处的xxx表示8个基本数据类型。若该字段的类型是引用数据类型则使用，Object get(Object obj);
//        void setXxx(Object obj,xxx val):将obj对象的该Field字段设置成val值，此处的xxx表示8个基本数据类型。若该字段的类型是引用数据类型则使用，void set(Object obj, Object value);