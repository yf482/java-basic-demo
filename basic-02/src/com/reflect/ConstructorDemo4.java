package com.reflect;
import java.lang.reflect.Constructor;

class Emp{
    private String name;
    private int age;
    private Emp() {
    }
    Emp(String name){
    }
    public Emp(String name,int age){
    }
}

public class ConstructorDemo4 {
    public static void main(String[] args) throws Exception {
        //得到所有的构造器（先得到类）
        Class<Emp> c = Emp.class;
        /**
         * Constructor<?>[] getConstructors()
         返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
         */
        Constructor[] con = c.getConstructors();//前面的修饰符必须是public才可以在这个方法下获取到
        for (Constructor cons : con) {
            System.out.println("c.getConstructors()"+cons);//如果上面的某构造器public去掉，则显示不出
            /**打印
             public junereflect624.Emp(java.lang.String,int)
             */
        }

        //得到指定的构造器,也是必须public
        Constructor c1 = c.getConstructor(String.class,int.class);
        System.out.println(c1);//public junereflect624.Emp(java.lang.String,int)

        System.out.println("====================================");
        //现在想获得不受public影响的,getDeclaredConstructors(),暴力反射

        con = c.getDeclaredConstructors();
        for (Constructor cons : con) {

            System.out.println("c.getDeclaredConstructors()=="+cons);//此时不受修饰符的影响
            /**打印
             *  public junereflect624.Emp()
             public junereflect624.Emp(java.lang.String)
             public junereflect624.Emp(java.lang.String,int)
             */
        }
    }
}