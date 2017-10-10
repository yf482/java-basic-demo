package com.day15_16;

import java.util.ArrayList;
import java.util.Iterator;

public class FangXingDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<String> al = new ArrayList<String>();
        al.add("aa1");
        al.add("aa2");
        al.add("aa3");
        ArrayList<Integer> al2 = new ArrayList<Integer>();
        al2.add(1);
        al2.add(2);
        al2.add(3);
        pritColl(al);
        pritColl(al2);

    }

    public static void pritColl(ArrayList<?> al)//？占位符，不明确类型
    {
        Iterator<?> it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    //ArrayList<Student> al = new  ArrayList<Person>();左右类型必须一致
    public static <T> void pritColl2(ArrayList<T> al)//？不明确类型
    {
        Iterator<T> it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}


