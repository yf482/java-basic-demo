package com.fto;

public class ExtendDemo1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Person s = new Student("computer");
        s.show();
    }

}

class Person {
    private String name;
    public int age;

    Person() {
        System.out.println("fu");
        name = "zhangsan";
        age = 22;
    }

    protected void show() {//˽�з������࿴����
        System.out.println(name + age);
    }
}

class Student extends Person {
    private String major;

    Student(String major) {
        System.out.println("zi");
        this.major = major;
    }

    public void show() {
        super.show();
        System.out.println(super.age + major);
    }
}
