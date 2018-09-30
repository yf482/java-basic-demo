package com.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetPrac {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TreeSet ts = new TreeSet(new StringComparator());
        ts.add("ddd");
        ts.add("aac");
        ts.add("aab");
        ts.add("baaa");

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s + "--" + s.length());
        }

    }

}

class StringComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub
        String s1 = (String) o1;
        String s2 = (String) o1;
//		if(s1.length()>s2.length()) 
//			return 1;
//		if(s1.length()==s2.length()) 
//			return 0;
//		return -1;
        int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
        if (num == 0)
            return s1.compareTo(s2);
        return num;

    }

}