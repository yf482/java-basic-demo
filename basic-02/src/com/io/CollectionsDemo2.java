package com.io;

import java.util.*;

public class CollectionsDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		orderDemo();
        fillDemo();

    }


    public static void orderDemo() {
//		TreeSet<String> ts =new TreeSet<String>(Collections.reverseOrder(new StrLenComparator2()));
        TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());
        ts.add("aa");
        ts.add("ddde");
        ts.add("d");
        ts.add("bb");
        ts.add("eeeee");

        Iterator it = ts.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    public static void fillDemo() {
        List<String> list = new ArrayList<String>();

        list.add("cs");
        list.add("aaa");
        list.add("cdcs");
        list.add("aaea");
        list.add("bbcs");
        list.add("zdd");

        System.out.println(list);


        //replaceAll();
        Collections.replaceAll(list, "aaa", "ppp");
        System.out.println(list);
        //fill
//		Collections.fill(list, "ddd");
        System.out.println(list);
        //shuffle
        Collections.shuffle(list);
        System.out.println(list);
    }


}

class StrLenComparator2 implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        if (o1.length() > o2.length())
            return 1;
        if (o1.length() < o2.length())
            return -1;
        return o1.compareTo(o2);
    }

}


