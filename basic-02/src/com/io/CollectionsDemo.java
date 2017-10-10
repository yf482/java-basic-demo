package com.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        sortDemo();
    }

    public static void sortDemo() {
        List<String> list = new ArrayList<String>();

        list.add("cs");
        list.add("aaa");
        list.add("cdcs");
        list.add("aaea");
        list.add("bbcs");
        list.add("zdd");
        System.out.println(list);
        String max = Collections.max(list);
        System.out.println("max=" + max);
        Collections.sort(list, new StrLenComparator());
        String max2 = Collections.max(list, new StrLenComparator());
        System.out.println("max2=" + max2);
        System.out.println(list);
        int num = halfSearch(list, "dddd");
        System.out.println(num);

    }

    public static int halfSearch(List<String> list, String key) {
        int min, max, mid;
        max = list.size() - 1;
        min = 0;
        while (min < max) {
            mid = (max + min) >> 1;// /2
            String str = list.get(mid);
            int num = str.compareTo(key);
            if (num > 0)
                max = mid - 1;
            else if (num < 0)
                min = mid + 1;
            else
                return mid;

        }
        return -min - 1;


    }

    public static int halfSearch2(List<String> list, String key, Comparator<String> cmp) {
        int min, max, mid;
        max = list.size() - 1;
        min = 0;
        while (min < max) {
            mid = (max + min) >> 1;// /2
            String str = list.get(mid);
            int num = cmp.compare(str, key);
            if (num > 0)
                max = mid - 1;
            else if (num < 0)
                min = mid + 1;
            else
                return mid;

        }
        return -min - 1;


    }

}

class StrLenComparator implements Comparator<String> {

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


