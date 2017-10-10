package com.day13_14;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        HashSet hs = new HashSet();
        hs.add(new Person1("z1", 22));
        System.out.println(hs.add(new Person1("z1", 22)));
        hs.add(new Person1("z3", 23));
        hs.add(new Person1("z4", 24));
        hs.add(new Person1("z5", 25));

        //按hashcode存入集合 ，所以无序的
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            Person1 p = (Person1) it.next();
            System.out.println(p.getName() + "---" + p.getAge());
        }

    }

}

class Person1 {
    private String name;
    private int age;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        System.out.println(name + "---hashcode");
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Person1 other = (Person1) obj;
        System.out.println(this.name + "--equals" + other.name);
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Person1))
            return false;

        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
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

    public Person1(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

}