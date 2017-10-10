package com.day15_16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapPractice {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashMap<Student, String> hm = new HashMap<Student, String>();
        hm.put(new Student("lisi1", 21), "shanghai1");
        hm.put(new Student("lisi3", 23), "shanghai2");
        hm.put(new Student("lisi4", 24), "shanghai3");
        hm.put(new Student("lisi5", 25), "shanghai4");
        //第一中取出
        Set<Student> keySet = hm.keySet();
        Iterator<Student> it = keySet.iterator();
        while (it.hasNext()) {
            Student stu = it.next();
            String addr = hm.get(stu);
            System.out.println(stu + "--" + addr);

        }
        //第二种取出
        Set<Map.Entry<Student, String>> entrySet = hm.entrySet();

        Iterator<Map.Entry<Student, String>> it2 = entrySet.iterator();

        while (it2.hasNext()) {
            Map.Entry<Student, String> me = it2.next();

            Student stu = me.getKey();
            String addr = me.getValue();
            System.out.println(stu + "--" + addr);
        }


    }

}

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public int hasCode() {
        return name.hashCode() + age * 34;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Student)
            throw new ClassCastException("类型不匹配");
        Student s = (Student) obj;
        return this.name == s.getName() && this.age == s.getAge();

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


    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        int num = new Integer(this.age).compareTo(new Integer(o.getAge()));
        if (num == 0)
            return this.name.compareTo(o.getName());
        return num;

    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

}