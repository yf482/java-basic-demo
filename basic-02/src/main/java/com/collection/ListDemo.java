package com.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List arr = new ArrayList();//al.add(Object obj)obj =new Person();
        arr.add(new Person("list01", 22));
        arr.add(new Person("list02", 25));
        arr.add(new Person("list03", 21));
        arr.add(new Person("list04", 24));

        Iterator it = arr.iterator();

        while (it.hasNext()) {
            Person p = (Person) it.next();
            System.out.println(p.getName() + "---" + p.getAge());
        }

        boolean flag = arr.contains(new Person("list01", 22));
        System.out.println(flag);
        boolean flag2 = arr.remove(new Person("list01", 22));
        System.out.println(flag2);

        Iterator it2 = arr.iterator();
        while (it2.hasNext()) {
            Person p = (Person) it.next();
            System.out.println(p);
        }


    }


    @Test
    public void listPro() {
        List list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
        list.add(2, "xxx");
        System.out.println(list);
        System.out.println(list.size());
        list.set(1, "abc");
        System.out.println(list);
        list.remove(2);
        String str = (String) list.get(1);
        System.out.println(str);

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        List list2 = new ArrayList(list);

        Iterator it2 = list2.iterator();
        //when iterator can not operator collection  throw exception
        while (it2.hasNext()) {
            Object obj = it2.next();
            if (obj.equals("abc1")) {
                list2.add("eee");
            } else {
                System.out.print(it2.next() + ",");
            }
            System.out.print(it2.next() + ",");
        }
        System.out.println(list2);
    }


    @Test
    public void testSingleElementDemo() {
        ArrayList al = new ArrayList();
        ArrayList newAl = new ArrayList();
        al.add("java01");
        al.add("java02");
        al.add("java02");
        al.add("java03");
        al.add("java01");
        newAl = singleElementDemo(al);
        System.out.println(newAl);
        Iterator it = newAl.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        List<Person> list = new ArrayList<Person>();
        Person p1 = new Person("yunfeng", 12);

    }

    /**
     * 测试对象equals、hashCode方法
     */
    @Test
    public void testSingleElementDemo2() {

        List<Person> list = new ArrayList<Person>();
        Person p1 = new Person("yunfeng", 12);
        Person p2 = new Person("yunfeng", 12);
        //用obj的equals方法
//		boolean flag = p1.equals(p2);

        list.add(p1);
//		list.add(p2);
        //遍历list 使用obj的equals方法  this==obj return true;
//		System.out.println(list.contains(p1));
        System.out.println(list.contains(p2));

    }

    /**
     * remove repeat element  from list
     *
     * @param arr
     * @return
     */
    public static ArrayList singleElementDemo(ArrayList arr) {

        ArrayList newArr = new ArrayList();
        Iterator it = arr.listIterator();

        while (it.hasNext()) {
            Object obj = it.next();
            if (!newArr.contains(obj))
                newArr.add(obj);
        }
        return newArr;
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