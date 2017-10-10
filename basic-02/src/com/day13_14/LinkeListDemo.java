package com.day13_14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkeListDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList link = new LinkedList();
        link.addLast("java01");
        link.addLast("java02");
        link.addLast("java03");
        link.addLast("java04");
//		System.out.println(link.getFirst());
//		System.out.println(link.getLast());
//		System.out.println(link.removeFirst());
//		System.out.println(link.removeFirst());
//		System.out.println(link.size());

        while (!link.isEmpty()) {
            System.out.println(link.removeLast());
        }
        System.out.println(link.size());

        //队列
        Duilie d = new Duilie();
        d.addLinked("iso01");
        d.addLinked("iso02");
        d.addLinked("iso03");
        d.addLinked("iso04");

        while (!d.isNull()) {
            System.out.println(d.deleteLinked());
        }
        //去除重复元素ArrayList
        ArrayList al = new ArrayList();
        ArrayList newAl = new ArrayList();
        al.add("java01");
        al.add("java02");
        al.add("java02");
        al.add("java03");
        al.add("java01");
        newAl = singleElementDemo(al);
        System.out.println(newAl);

        //		it.next()一次就取一次 指针向下移动/，
        //		再次it.next就可以越界了就会报错

        Iterator it = newAl.iterator();
        while (it.hasNext()) {
            //System.out.println(it.next()+"---"+it.next());
        }


    }

    //ArrayList中去除中重复的数据
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

class Duilie {
    private LinkedList link;

    Duilie() {
        link = new LinkedList();
    }

    public void addLinked(Object obj) {
        link.addFirst(obj);
    }

    public Object deleteLinked() {
        return link.removeLast();
    }

    public boolean isNull() {
        return link.isEmpty();
    }


}
