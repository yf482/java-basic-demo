package com.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class AB{
    protected String name;
    protected String id;
}
@Deprecated
public class MethodDemo5 extends AB{
    void show(){}
    public void say(){}
    private int age;
    public char c;
    private boolean b;
    public static void main(String[] args) throws Exception {
        Class<MethodDemo5> c = MethodDemo5.class;
        //获取所有的（包含父类的方法）public修饰的方法
        Method[] m = c.getMethods();
        for (Method method : m) {
            System.out.println(method);
        }
        //总结：4个方法，获取全部，获取特定；不受修饰符影响的全部，不受修饰符影响的特定；（前两个都还是受限制的）

        //获取指定的方法
        Method me = c.getMethod("main", String[].class);
        System.out.println("main "+me);//main public static void junereflect624.MethodDemo5.main(java.lang.String[]) throws java.lang.Exception

        //访问所有方法，不受访问权限影响
        m = c.getDeclaredMethods();
        for (Method method : m) {
            System.out.println("不受影响的："+method);
        }

        me = c.getDeclaredMethod("show");
        System.out.println(me);//void junereflect624.MethodDemo.show()

        me = c.getMethod("toString");
        System.out.println(me);//public java.lang.String java.lang.Object.toString()

        /**
         * Method[] getDeclaredMethods()
         返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，
         包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法,只可以对当前类有效
         */
		/*me = c.getDeclaredMethod("toString");//ERROR,c.getDeclaredMethod()不能得到继承的方法
		System.out.println(me);//public java.lang.String java.lang.Object.toString()
		 */
        //得到字段
        Field[] f = c.getFields();
        for (Field field : f) {//只得到了public的
            System.out.println("字段"+field);
        }

        //特定字段
        Field fi = c.getField("c");//""里面是名称
        System.out.println(fi);//public char junereflect624.MethodDemo.c

        //得到不受限定名限定的全部字段
        f = c.getDeclaredFields();
        for (Field field : f) {//得到不受修饰符限定的字段，但是只对当前类有效
            System.out.println("全部字段："+field);
            /**
             *  全部字段：private int junereflect624.MethodDemo.age
             全部字段：public char junereflect624.MethodDemo.c
             全部字段：private boolean junereflect624.MethodDemo.b
             */
        }
        //注释  Annotation
        Annotation[] a = c.getAnnotations();
        System.out.println(a.length);
        for (Annotation annotation : a) {
            System.out.println(annotation);
        }

        //特定注解
        Deprecated d = c.getAnnotation(Deprecated.class);
        System.out.println(d);
    }
}