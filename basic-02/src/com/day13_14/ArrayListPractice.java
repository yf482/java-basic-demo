package com.day13_14;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPractice {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList al = new ArrayList();//al.add(Object obj);����������obj =new Person();
        al.add(new Person("list01", 22));
        al.add(new Person("list02", 25));
        al.add(new Person("list03", 21));
        al.add(new Person("list04", 24));

        Iterator it = al.iterator();

        while (it.hasNext()) {
            Person p = (Person) it.next();


            System.out.println(p.getName() + "---" + p.getAge());
        }


    }

}

class Person {
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    //�Ƚ϶����Ƿ���ͬ
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Person))
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }


}