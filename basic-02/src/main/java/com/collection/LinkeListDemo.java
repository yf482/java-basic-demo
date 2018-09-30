package com.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkeListDemo {

    @Test
    public void testBasic() {
        // TODO Auto-generated method stub
        LinkedList link = new LinkedList();
        link.addLast("java01");
        link.addLast("java02");
        link.addLast("java03");
        link.addLast("java04");
        System.out.println(link.getFirst());
        System.out.println(link.getLast());
        System.out.println(link.removeFirst());
        System.out.println(link.removeFirst());
        System.out.println(link.size());

        while (!link.isEmpty()) {
            System.out.println(link.removeFirst());
        }
        System.out.println(link.size());

        LinkedList link2 = new LinkedList();
        link2.addLast("java01");
        link2.addLast("java02");
//		link2.clear();
        //jdk 1.6 first produce
        System.out.println(link2.peekFirst());
        System.out.println(link2.peekLast());
        Iterator it = link2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(link2.size());

    }

    @Test
    public void test1() {
        //first in first out
        Duilie d = new Duilie();
        d.addLinked("iso01");
        d.addLinked("iso02");
        d.addLinked("iso03");
        d.addLinked("iso04");
        while (!d.isNull()) {
            System.out.println(d.deleteLinked());
        }
    }

    @Test
    public void testStack() {
        //first in last out
        Stack d = new Stack();
        d.addLinked("iso01");
        d.addLinked("iso02");
        d.addLinked("iso03");
        d.addLinked("iso04");
        while (!d.isNull()) {
            System.out.println(d.deleteLinked());
        }
    }


}

/**
 * queue class simulation
 *
 * @author v_wbyfli
 */
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

/**
 * stack simulation
 *
 * @author v_wbyfli
 */
class Stack {
    private LinkedList link;

    Stack() {
        link = new LinkedList();
    }

    public void addLinked(Object obj) {
        link.addFirst(obj);
    }

    public Object deleteLinked() {
        return link.removeFirst();
    }

    public int size() {
        return link.size();
    }

    public boolean isNull() {
        return link.isEmpty();
    }
}


