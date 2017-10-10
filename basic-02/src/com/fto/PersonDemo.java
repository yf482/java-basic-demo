package com.fto;

public class PersonDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Person p1 = new Person();
        Person p2 = new Person("zhangsan");
        Person p3 = new Person("lisi", 23);
    }

}

//一个类可以有多个构造函数，不需要返回值，和类名相同
class Person {

    private String name;
    private int age;

    //构造代码快不同构造函数共性的初始化
    {
        smile();
    }


    Person() {
//		System.out.println("A:name="+name+",,age="+age);
//		smile();
    }

    //this用于区分局部变量和成员变量重名的情况
    Person(String name) {
        this.name = name;
//		System.out.println("B:name="+name+",,age="+age);
//		smile();
    }

    Person(String name, int age) {
        this(name);//调用其他构造方法
        this.age = age;
//		System.out.println("C:name="+name+",,age="+age);
//		smile();
    }

    void smile() {
        System.out.println("smile....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //this 指向该对象的引用
    boolean compare(Person p) {
        return this.age == p.getAge();
    }

}
