package com.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author yunfeng
 * @version V.1.0
 * @Desc 方法上的泛型
 * @create 2017/10/15 23:51
 **/
public class GenericDemo3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("aa1");
        al.add("aa2");
        al.add("aa3");
        ArrayList<Integer> al2 = new ArrayList<Integer>();
        al2.add(1);
        al2.add(2);
        al2.add(3);
        pritColl(al);
        pritColl2(al2);

    }

    public static void pritColl(ArrayList<?> al) {
        Iterator<?> it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    //ArrayList<Student> al = new  ArrayList<Person>()
    public static <T> void pritColl2(ArrayList<T> al) {
        Iterator<T> it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}


