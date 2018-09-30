package com.reflect;

import java.lang.reflect.Field;

class Stu{
    public String name;
    public String sex;
    public int age;

    public Stu(String name, String sex, int age) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}

public class ReflectDemo6 {
    public static void main(String[] args) throws Exception {
        Stu s = new Stu("刘昭", "男", 12);

        Class<Stu> c = Stu.class;

        Field f = c.getField("name");
        System.out.println(f.get(s));////从哪个对象身上取！此时显示刘昭！
//	修改对象的值
/**
 Field f = c.getField("name");
 f.set(s,"章泽天");
 System.out.println(f.get(s));//从哪个对象身上取！//此时显示章泽天
 */
    }
}