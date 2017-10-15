package com.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class CompareDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeSet<String> al = new TreeSet<String>(new LenComparator());
        al.add("aaa");
        al.add("aa1");
        al.add("aaa22");
        al.add("a2");
//		al.add(4);
        Iterator<String> it = al.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }

}

class LenComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int num = new Integer(o2.length()).compareTo(new Integer(o1.length()));
        if (num == 0)
            return o2.compareTo(o1);
        return num;
    }

}
