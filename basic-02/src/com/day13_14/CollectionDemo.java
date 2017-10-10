package com.day13_14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class CollectionDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub


        ListIteratorUse();
    }

    public static void listUse() {
        ArrayList al = new ArrayList();

        al.add("abc1");
        al.add("abc2");
        al.add("abc3");
        al.add("abc4");
        System.out.println("原集合：" + al);
        al.remove(2);
        System.out.println("删元素集合：" + al);
        System.out.println("abc1是否存在集合" + al.contains("abc1"));
        //al.clear();
        //System.out.println("删集合："+al);

        System.out.println(al.isEmpty());

        ArrayList al2 = new ArrayList();
        al2.add("abc1");
        al2.add("abc22");
        al2.add("abc33");
        al2.add("abc44");
        al.retainAll(al2);
        System.out.println(al);

    }

    public static void iteratorUse() {
        ArrayList al = new ArrayList();
        al.add("ab1");
        al.add("ab2");
        al.add("ab3");
        al.add("ab4");
        Iterator it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //用for it 使用完成后 自动销毁it对象，不占用内存。wihle没有这样的效果
//		for(Iterator it1 = al.iterator();it1.hasNext();)
//		{
//			System.out.println(it1.next());
//		}
    }

    public static void ListIteratorUse() {
        ArrayList al = new ArrayList();
        al.add("ab1");
        al.add("ab2");
        al.add("ab3");
        al.add("ab4");
        System.out.println(al);
        ListIterator it = al.listIterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj.equals("ab2")) {
                it.set("aaa");
            }
        }
        System.out.println(al);
        //指针，一个指向下一个元素，一个指向前一个元素
        System.out.println(it.hasNext());
        System.out.println(it.hasPrevious());
        while (it.hasPrevious()) {
            Object obj = it.next();
            System.out.println(it.next());
        }
    }


    public static void listUse1() {
        ArrayList al = new ArrayList();
        al.add("ab1");
        al.add("ab2");
        al.add("ab3");
        al.add("ab4");
        System.out.println(al);
        al.add(1, "ab5");
        System.out.println(al);
        al.remove(2);
        System.out.println(al);
        al.set(1, "bbb");
        System.out.println(al);
        System.out.println(al.get(1));
        for (int x = 0; x < al.size(); x++) {
            System.out.print(al.get(x) + "--");
        }
    }


}
